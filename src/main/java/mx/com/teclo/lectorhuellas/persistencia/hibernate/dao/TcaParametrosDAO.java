package mx.com.teclo.lectorhuellas.persistencia.hibernate.dao;


import mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.TcaParametrosDTO;
import mx.com.teclo.lectorhuellas.persistencia.vo.ParametrosVO;
import mx.com.teclomexicana.arquitectura.persistencia.comun.dao.BaseDao;

public interface TcaParametrosDAO extends BaseDao<TcaParametrosDTO> {
	
	/**
	 * Regresa en milisegundos el tiempo para cerrar la modal de asistencia.<br>
	 * Uno para registrar y otro para consultar. Son parametros por ambiente.
	 * 
	 * @param ambiente
	 * @return
	 */
	ParametrosVO getParametros(String ambiente);
	
	/**
	 * Recupera el conjunto de par\u00E1metros por ambiente de arquitectura:
	 * <ul>
	 * <li>D_O es desarrollo</li>
	 * <li>Q_O es calidad</li>
	 * <li>P_O es producci\u00F3n</li>
	 * </ul>
	 * @param ambiente
	 * @return
	 */
	TcaParametrosDTO findParametrosByAmbiente(String ambiente);

}
