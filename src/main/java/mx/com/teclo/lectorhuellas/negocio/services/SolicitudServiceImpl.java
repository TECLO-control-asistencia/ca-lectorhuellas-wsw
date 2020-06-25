/**
 * 
 */
package mx.com.teclo.lectorhuellas.negocio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.teclo.lectorhuellas.persistencia.hibernate.dao.RegistroMyBatisDAO;
import mx.com.teclo.lectorhuellas.persistencia.hibernate.dao.SolicitudDAO;
import mx.com.teclo.lectorhuellas.persistencia.vo.SolicitudLecturaVO;
import mx.com.teclo.lectorhuellas.util.comun.EnumTipoSolicitud;

/**
 * @author UNITIS-ODM2
 *
 */
@Service
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	private SolicitudDAO solicitudDAO;

	@Autowired
	private RegistroMyBatisDAO registroMyBatisDAO;

	@Override
	@Transactional
	public SolicitudLecturaVO getUltimaSolicitud(Long idLector) {
		SolicitudLecturaVO solicitud = solicitudDAO.getUltimaSolicitud(idLector);
		if (solicitud == null) {
			return null;
		}
		if (solicitud.getTipoOperacion() == EnumTipoSolicitud.VERIFICACION.getId()) {
			solicitud.setHuellas(registroMyBatisDAO.consultaHuellas(solicitud.getIdEmpleado()));
		}
		solicitudDAO.bloquearSolicitud(solicitud.getIdSolicitud());
		return solicitud;
	}

}
