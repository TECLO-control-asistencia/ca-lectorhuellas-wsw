package mx.com.teclo.lectorhuellas.persistencia.vo;

import mx.com.teclo.arquitectura.ortogonales.persistencia.configuracion.vo.ConfiguracionVO;

public class ConfiguracionWrapperVO {
	private ConfiguracionVO configuracionVO;
	private ParametrosVO parametrosVO;

	public ConfiguracionVO getConfiguracionVO() {
		return configuracionVO;
	}

	public void setConfiguracionVO(ConfiguracionVO configuracionVO) {
		this.configuracionVO = configuracionVO;
	}

	public ParametrosVO getParametrosVO() {
		return parametrosVO;
	}

	public void setParametrosVO(ParametrosVO parametrosVO) {
		this.parametrosVO = parametrosVO;
	}

}
