package mx.com.teclo.lectorhuellas.persistencia.hibernate.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import mx.com.teclo.lectorhuellas.persistencia.vo.HuellasVO;

@Mapper
public interface RegistroMyBatisDAO {

	static final String CONSULTA_HUELLAS = "	select                     "
			+ "		TCA011.ID_TURNO as turnoId,tca012.Huella as huella     "
			+ "	from TCA011D_EMPLEADO_TURNO TCA011                         "
			+ "	Left join TCA012D_HUELLAS_USUARIOS  tca012                 "
			+ "		on tca012.id_empleado=TCA011.ID_EMPLEADO               "
			+ "		and tca012.St_activo=1                                 "
			+ "	where TCA011.ST_ACTIVO=1                                   "
			+ "	and TCA011.ID_EMPLEADO=#{empleadoIdHuella} 			   	   ";

	@Select(CONSULTA_HUELLAS)
	List<HuellasVO> consultaHuellas(@Param("empleadoIdHuella") Long empleadoId);

}
