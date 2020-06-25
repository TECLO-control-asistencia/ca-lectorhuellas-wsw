package mx.com.teclo.lectorhuellas.persistencia.hibernate.dao;

import java.util.List;

import mx.com.teclo.lectorhuellas.persistencia.hibernate.dto.TcaLectorDTO;
import mx.com.teclo.lectorhuellas.persistencia.vo.LectorVO;
import mx.com.teclomexicana.arquitectura.persistencia.comun.dao.BaseDao;

public interface TcaLectorDAO extends BaseDao<TcaLectorDTO> {
	

	LectorVO getLectorByIp(String ipRemota);

	List<String> getIpsConLector();

	TcaLectorDTO findByIp(String ipRemota);

	Long crearLector(String ipRemota, Long idEmpleado);

	boolean isRunning(String ipRemota);
}
