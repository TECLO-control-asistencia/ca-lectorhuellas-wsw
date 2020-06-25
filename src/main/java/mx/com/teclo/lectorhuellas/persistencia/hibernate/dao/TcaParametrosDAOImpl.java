package mx.com.teclo.lectorhuellas.persistencia.hibernate.dao;


import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.TcaParametrosDTO;
import mx.com.teclo.lectorhuellas.persistencia.vo.ParametrosVO;
import mx.com.teclomexicana.arquitectura.persistencia.comun.dao.BaseDaoHibernate;

@Repository
public class TcaParametrosDAOImpl extends BaseDaoHibernate<TcaParametrosDTO> implements TcaParametrosDAO {
	
	public ParametrosVO getParametros(String ambiente) {
		Criteria criteria = getCurrentSession().createCriteria(TcaParametrosDTO.class);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("nuMilisegRegistro").as("tiempoRegistroMs"))
				.add(Projections.property("nuMilisegConsulta").as("tiempoConsultaMs"))
				.add(Projections.property("nuMilisegIntervalo").as("tiempoIntervaloMs"))
				.add(Projections.property("appHuellasVisible").as("appHuellasVisible")));
		criteria.setResultTransformer(Transformers.aliasToBean(ParametrosVO.class));
		criteria.add(Restrictions.eq("nbAmbiente", ambiente.trim()));
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		return (ParametrosVO) criteria.uniqueResult();		
	}

	@Override
	public TcaParametrosDTO findParametrosByAmbiente(String ambiente) {
		Criteria criteria = getCurrentSession().createCriteria(TcaParametrosDTO.class);		
		criteria.add(Restrictions.eq("nbAmbiente", ambiente.trim()));
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		return (TcaParametrosDTO) criteria.uniqueResult();		
	}
}
