package mx.com.teclo.lectorhuellas.negocio.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mx.com.teclo.lectorhuellas.persistencia.hibernate.dao.TcaLectorDAO;
import mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.TcaLectorDTO;
import mx.com.teclo.lectorhuellas.persistencia.vo.LectorVO;
import mx.com.teclo.lectorhuellas.persistencia.vo.ParametrosVO;
import mx.com.teclomexicana.arquitectura.ortogonales.exception.BusinessException;


@Service
public class JnlpServiceImpl implements JnlpService {

	@Value("${jnlp.dir.desktop}")
	private String contextJnlp;

	@Value("${jnlp.dir.index}")
	private String contextIndexJnlp;

	@Value("${jnlp.dir.route}")
	private String contextRouteJnlp;
	
	@Value("${jnlp.app.context}")
	private String contextAppJnlp;

	@Autowired
	private ServletContext context;

	@Autowired
	private TcaLectorDAO lectorDAO;
	
	@Autowired
	private ParametrosService parametrosService;
	

	@Override
	@Transactional
	public String crearJnlp(String ipRemota) throws BusinessException {
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		LectorVO lectorVO = lectorDAO.getLectorByIp(ipRemota);
		if (lectorVO == null) {
			throw new BusinessException("El lector no existe en la IP remota");
		}
		ParametrosVO parametros = parametrosService.getParametros();
	

		Document document = new Document();
		Element root = new Element("jnlp");
		root.setAttribute(new Attribute("spec", "1.0+"));
		root.setAttribute(new Attribute("codebase", contextAppJnlp));
		root.setAttribute(new Attribute("href", "jnlp/aplicacion_" + lectorVO.getIdLector() + ".jnlp"));

		document.setRootElement(root);

		Element information = new Element("information");
		information.addContent(new Element("title").setText("Control de Asistencia"));
		information.addContent(new Element("vendor").setText("Teclo Mexicana S.A. de C.V."));
		information.addContent(new Element("homepage").setAttribute("href", "http://teclomexicana.mx"));
		information.addContent(new Element("description").setText("Control de Asistencia"));

		Element shortcut = new Element("shortcut");
		shortcut.setAttribute("online", "true");
		information.addContent(shortcut);

		Element shortcut2 = new Element("shortcut");
		shortcut2.setAttribute("online", "true");
		shortcut2.setAttribute("install", "true");

		Element desktop = new Element("desktop");
		shortcut2.addContent(desktop);

		Element menu = new Element("menu");
		menu.setAttribute("submenu", "Control de Asistencia");
		shortcut2.addContent(menu);

		information.addContent(shortcut2);

		Element offline = new Element("offline-allowed");
		information.addContent(offline);

		document.getRootElement().addContent(information);

		Element security = new Element("security");
		security.addContent(new Element("all-permissions")); // all-permissions
		document.getRootElement().addContent(security);

		Element update = new Element("update");
		update.setAttribute("check", "background"); // background
		update.setAttribute("policy", "prompt-update");
		document.getRootElement().addContent(update);

		Element resourcesx86 = new Element("resources");
		resourcesx86.setAttribute("arch", "x86");

		Element resourcesx64 = new Element("resources");
		resourcesx64.setAttribute("arch", "amd64");

		Element j2sex86 = new Element("j2se");
		j2sex86.setAttribute("version", "1.7+");
		j2sex86.setAttribute("href", "http://java.sun.com/products/autodl/j2se");
		j2sex86.setAttribute("initial-heap-size", "32m");
		j2sex86.setAttribute("max-heap-size", "128m");
		j2sex86.setAttribute("java-vm-args", "-ea");

		Element j2sex64 = new Element("j2se");
		j2sex64.setAttribute("version", "1.7+");
		j2sex64.setAttribute("href", "http://java.sun.com/products/autodl/j2se");
		j2sex64.setAttribute("initial-heap-size", "32m");
		j2sex64.setAttribute("max-heap-size", "128m");
		j2sex64.setAttribute("java-vm-args", "-ea");

		Element jarx86 = new Element("jar");
		jarx86.setAttribute("href", "jnlp/jar/ca-registro-app-1.0.0.jar");
		jarx86.setAttribute("main", "true");

		Element jarx64 = new Element("jar");
		jarx64.setAttribute("href", "jnlp/jar/ca-registro-app-1.0.0.jar");
		jarx64.setAttribute("main", "true");

		Element propertyx86 = new Element("property");
		propertyx86.setAttribute("name", "jnlp.packEnabled");
		propertyx86.setAttribute("value", "true");

		Element propertyx64 = new Element("property");
		propertyx64.setAttribute("name", "jnlp.packEnabled");
		propertyx64.setAttribute("value", "true");

		resourcesx86.addContent(j2sex86);
		resourcesx86.addContent(jarx86);
		resourcesx86.addContent(propertyx86);
		document.getRootElement().addContent(resourcesx86);

		resourcesx64.addContent(j2sex64);
		resourcesx64.addContent(jarx64);
		resourcesx64.addContent(propertyx64);
		document.getRootElement().addContent(resourcesx64);

		Element application_desc = new Element("application-desc");
		application_desc.setAttribute("name", "Control Asistencia");
		application_desc.setAttribute("main-class", "mx.com.teclo.App");
		application_desc.addContent(new Element("argument").setText(lectorVO.getIdLector().toString()));
		application_desc.addContent(new Element("argument").setText(baseUrl));
		application_desc.addContent(new Element("argument").setText(parametros.getAppHuellasVisible().toString()));
		document.getRootElement().addContent(application_desc);

		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());

		String directory = context.getRealPath("/");
		try {
			Pattern test = Pattern.compile(contextIndexJnlp);
			Matcher testM = test.matcher(directory);
			if (testM.find()) {
				int posi = directory.indexOf(contextIndexJnlp);
				String newDirectory = directory.substring(0, posi);
				newDirectory += contextRouteJnlp + File.separator + contextJnlp + "aplicacion_" + lectorVO.getIdLector()
						+ ".jnlp";
				xmlOutput.output(document, new FileWriter(newDirectory));
				return obtenerUrlJnlp(contextAppJnlp, lectorVO.getIdLector());
			} else {
				return StringUtils.EMPTY;
			}
		} catch (IOException e) {
			return StringUtils.EMPTY;
		}

	}

	private String obtenerUrlJnlp(String urlLocal, Long idLector) throws BusinessException {
		if (StringUtils.isBlank(urlLocal) || !urlLocal.contains("http")) {
			throw new BusinessException("Url invalida");
		}
		return urlLocal + "jnlp/aplicacion_" + idLector + ".jnlp";
	}

	@Override
	@Transactional
	public String getUrlJnlpVigente(String ipRemota, Long idEmpleado) throws BusinessException {
		TcaLectorDTO lector = lectorDAO.findByIp(ipRemota);
		if (lector == null) {
			Long idLector = lectorDAO.crearLector(ipRemota, idEmpleado);
			TcaLectorDTO nvoLector = lectorDAO.findOne(idLector);
			String url = crearJnlp(ipRemota);
			nvoLector.setNbUrlJnlp(url);
			lectorDAO.update(nvoLector);
			lectorDAO.flush();
			return url;
		}
				
		boolean isRunning  = lectorDAO.isRunning(ipRemota);
		if(!isRunning || StringUtils.isBlank(lector.getNbUrlJnlp())) {		
			String url = crearJnlp(ipRemota);
			lector.setNbUrlJnlp(url);
			lector.setFhModificacion(new Date());
			lector.setIdUsrModifica(idEmpleado);
			lectorDAO.saveOrUpdate(lector);
			return url;			
		}

		return lector.getNbUrlJnlp();
	}

	@Transactional
	@Override
	public void saveSessionHandShake(Long idLector, String session) {
		TcaLectorDTO lector = lectorDAO.findOne(idLector);
		lector.setFhModificacion(new Date());
		lector.setIdCanal(session);
		lectorDAO.save(lector);
	}

	@Override
	@Transactional
	public Long crearDispositivoByIp(String ipRemota) {
		TcaLectorDTO lector = lectorDAO.findByIp(ipRemota);
		if (lector != null) {
			return lector.getIdLector();
		}
		Long idLector = lectorDAO.crearLector(ipRemota, BigDecimal.ZERO.longValue());
		return idLector;	
	}
	
	@Override
	@Transactional
	public boolean isRunning(String ipRemota) {
		return lectorDAO.isRunning(ipRemota);
	}

	@Override
	@Transactional
	public void savePing(Long idLector) {
		TcaLectorDTO lector = lectorDAO.findOne(idLector);
		lector.setFhUltimoPing(new Date());
		lectorDAO.save(lector);
		
	}
}