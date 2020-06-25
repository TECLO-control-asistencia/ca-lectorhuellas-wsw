package mx.com.teclo.lectorhuellas.negocio.services;

import org.springframework.stereotype.Service;

import mx.com.teclo.lectorhuellas.persistencia.vo.ParametrosVO;

@Service
public class ParametrosServiceImpl implements ParametrosService {
	private static final Long TIEMPO_CONSULTA_MS = 5000L;
	private static final Long TIEMPO_REGISTRO_MS = 10000L;
	private static final Long TIEMPO_INTERVALO_MS = 3000L;

	@Override
	public ParametrosVO getParametros() {
		ParametrosVO parametrosVO = new ParametrosVO();
		parametrosVO.setTiempoConsultaMs(TIEMPO_CONSULTA_MS);
		parametrosVO.setTiempoRegistroMs(TIEMPO_REGISTRO_MS);
		parametrosVO.setTiempoIntervaloMs(TIEMPO_INTERVALO_MS);
		parametrosVO.setAppHuellasVisible(Boolean.FALSE);
		return parametrosVO;
	}

}
