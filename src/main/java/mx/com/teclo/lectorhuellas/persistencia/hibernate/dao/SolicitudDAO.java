package mx.com.teclo.lectorhuellas.persistencia.hibernate.dao;

import mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.SolicitudDTO;
import mx.com.teclo.lectorhuellas.persistencia.vo.SolicitudLecturaVO;
import mx.com.teclomexicana.arquitectura.persistencia.comun.dao.BaseDao;

public interface SolicitudDAO extends BaseDao<SolicitudDTO> {

	SolicitudLecturaVO getUltimaSolicitud(Long idLector);

	void bloquearSolicitud(Long idSolicitud);
	
	SolicitudDTO findByEmpleado(Long idEmpleado);

}
