package mx.com.teclo.lectorhuellas.persistencia.hibernate.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.SolicitudDTO;
import mx.com.teclo.lectorhuellas.persistencia.vo.SolicitudLecturaVO;
import mx.com.teclomexicana.arquitectura.persistencia.comun.dao.BaseDaoHibernate;

@Repository
public class SolicitudDAOImpl extends BaseDaoHibernate<SolicitudDTO> implements SolicitudDAO {
	private static final String BLOQUEAR_SOLICITUD_QUERY = "UPDATE SolicitudDTO s SET fechaAtencion = sysdate WHERE s.idSolicitud = :idSolicitud)";

	@Override
	public SolicitudLecturaVO getUltimaSolicitud(Long idLector) {
		Date currentDate = new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1));
		Criteria criteria = getCurrentSession()
				.createCriteria(mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.SolicitudDTO.class, "solicitud");
		criteria.createAlias("solicitud.lectorDTO", "lector", JoinType.LEFT_OUTER_JOIN);
		criteria.createAlias("solicitud.empleadoDTO", "empleado", JoinType.LEFT_OUTER_JOIN);

		criteria.add(Restrictions.eq("lector.idLector", idLector));
		criteria.add(Restrictions.isNotNull("lector.idCanal"));
		criteria.add(Restrictions.isNull("solicitud.fechaAtencion"));
		criteria.add(Restrictions.ge("solicitud.fechaCreacion", currentDate));

		criteria.setMaxResults(BigDecimal.ONE.intValue());
		criteria.setProjection(
				Projections.projectionList().add(Projections.property("solicitud.idSolicitud").as("idSolicitud"))
						.add(Projections.property("empleado.empId").as("idEmpleado"))
						.add(Projections.property("lector.idCanal").as("idCanal"))
						.add(Projections.property("solicitud.cdOperacion").as("tipoOperacion")));

		criteria.addOrder(Order.desc("solicitud.idSolicitud"));
		criteria.setResultTransformer(Transformers.aliasToBean(SolicitudLecturaVO.class));
		return (SolicitudLecturaVO) criteria.uniqueResult();
	}

	@Override
	public void bloquearSolicitud(Long idSolicitud) {
		Query q = getCurrentSession().createQuery(BLOQUEAR_SOLICITUD_QUERY);
		q.setLong("idSolicitud", idSolicitud);
		q.executeUpdate();

	}

	@Override
	public SolicitudDTO findByEmpleado(Long idEmpleado) {
		Criteria criteria = getCurrentSession().createCriteria(SolicitudDTO.class, "solicitud");
		criteria.createAlias("solicitud.empleadoDTO", "empleado", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("empleado.empId", idEmpleado));
		criteria.setMaxResults(BigDecimal.ONE.intValue());
		return (SolicitudDTO) criteria.uniqueResult();

	}

}
