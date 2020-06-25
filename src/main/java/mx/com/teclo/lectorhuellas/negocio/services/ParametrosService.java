package mx.com.teclo.lectorhuellas.negocio.services;

import mx.com.teclo.arquitectura.ortogonales.persistencia.configuracion.vo.ConfiguracionVO;
import mx.com.teclo.lectorhuellas.persistencia.vo.ConfiguracionWrapperVO;
import mx.com.teclo.lectorhuellas.persistencia.vo.ParametrosVO;


public interface ParametrosService {


	/**
	 * Recupera los par\u00E1metros de tiempos para<br>
	 * cerrar la modal de asistencia \u00E1gil.
	 * Hay un conjunto de par\u00E1metros por ambiente.
	 * @return
	 */
	ParametrosVO getParametros();
}
