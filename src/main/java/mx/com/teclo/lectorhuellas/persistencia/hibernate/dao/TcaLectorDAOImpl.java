package mx.com.teclo.lectorhuellas.persistencia.hibernate.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.TcaLectorDTO;
import mx.com.teclo.lectorhuellas.persistencia.vo.LectorVO;
import mx.com.teclomexicana.arquitectura.persistencia.comun.dao.BaseDaoHibernate;

@Repository
public class TcaLectorDAOImpl extends BaseDaoHibernate<TcaLectorDTO> implements TcaLectorDAO {
	@Override
	public LectorVO getLectorByIp(String ipRemota) {
		Criteria criteria = getCurrentSession().createCriteria(TcaLectorDTO.class, "lector");
		criteria.add(Restrictions.eq("lector.nbIp", ipRemota));
		criteria.add(Restrictions.eq("lector.stActivo", Boolean.TRUE.booleanValue()));

		criteria.setProjection(Projections.projectionList().add(Projections.property("lector.idLector").as("idLector"))
				.add(Projections.property("lector.nbIp").as("nbIp"))
				.add(Projections.property("lector.nbUrlJnlp").as("nbUrlJnlp"))
				.add(Projections.property("lector.running").as("running")));
		criteria.setResultTransformer(Transformers.aliasToBean(LectorVO.class));

		return (LectorVO) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getIpsConLector() {
		Criteria criteria = getCurrentSession().createCriteria(TcaLectorDTO.class, "lector");
		criteria.add(Restrictions.eq("lector.stActivo", Boolean.TRUE.booleanValue()));

		criteria.setProjection(Projections.projectionList().add(Projections.property("lector.nbIp").as("nbIp")));

		return criteria.list();
	}

	@Override
	public TcaLectorDTO findByIp(String ipRemota) {
		Criteria criteria = getCurrentSession().createCriteria(TcaLectorDTO.class, "lector");
		criteria.add(Restrictions.eq("lector.stActivo", Boolean.TRUE.booleanValue()));
		criteria.add(Restrictions.eq("lector.nbIp", ipRemota));
		return (TcaLectorDTO) criteria.uniqueResult();
	}

	@Override
	public Long crearLector(String ipRemota, Long idEmpleado) {
		TcaLectorDTO nvoLector = new TcaLectorDTO();
		nvoLector.setNbIp(ipRemota);
		nvoLector.setStActivo(Boolean.TRUE.booleanValue());
		nvoLector.setFhCreacion(new Date());
		nvoLector.setFhModificacion(new Date());
		nvoLector.setIdUsrCreacion(idEmpleado);
		nvoLector.setIdUsrModifica(idEmpleado);
		return (Long) save(nvoLector);
	}

	@Override
	public boolean isRunning(String ipRemota) {
		Criteria criteria = getCurrentSession().createCriteria(TcaLectorDTO.class, "lector");
		criteria.add(Restrictions.eq("lector.nbIp", ipRemota));
		criteria.add(Restrictions.eq("lector.stActivo", Boolean.TRUE.booleanValue()));

		criteria.setProjection(Projections.projectionList().add(Projections.property("lector.running").as("running")));

		return (Boolean) criteria.uniqueResult();
	}

}
