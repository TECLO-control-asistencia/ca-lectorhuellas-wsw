package mx.com.teclo.lectorhuellas.negocio.services;

import mx.com.teclo.lectorhuellas.persistencia.vo.SolicitudLecturaVO;

public interface SolicitudService {

	SolicitudLecturaVO getUltimaSolicitud(Long idLector);

	

}
