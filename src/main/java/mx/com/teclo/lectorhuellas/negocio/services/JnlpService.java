package mx.com.teclo.lectorhuellas.negocio.services;

import mx.com.teclomexicana.arquitectura.ortogonales.exception.BusinessException;

public interface JnlpService {

	/**
	 * Genera el archivo JNLP
	 * 
	 * @param ipRemota
	 * @return
	 * @throws BusinessException
	 */
	String crearJnlp(String ipRemota) throws BusinessException;

	/**
	 * Crea el lector si no existe y genera el JNLP
	 * 
	 * @param ipRemota
	 * @param idEmpleado
	 * @return Ruta para descargar el JNLP
	 * @throws BusinessException
	 */
	String getUrlJnlpVigente(String ipRemota, Long idEmpleado) throws BusinessException;

	/**
	 * Por cada conexion WebSocket se actualiza el lector con el ID de la sesion
	 * 
	 * @param idLector
	 * @param session
	 */
	void saveSessionHandShake(Long idLector, String session);

	/**
	 * Cuando haya una peticion para usar el lector, registrar la ip
	 * 
	 * @param ipRemota
	 * @return
	 */
	Long crearDispositivoByIp(String ipRemota);

	/**
	 * Regresa true si hay ping del lector en el ultimo minuto
	 * 
	 * @param ipRemota
	 * @return
	 */
	boolean isRunning(String ipRemota);

	/**
	 * Registra la hora en que se recibe el ping del ID lector
	 * 
	 * @param idLector
	 */
	void savePing(Long idLector);

}
