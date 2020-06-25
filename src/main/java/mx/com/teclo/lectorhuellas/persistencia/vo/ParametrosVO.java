package mx.com.teclo.lectorhuellas.persistencia.vo;

public class ParametrosVO {
	private Long idParametro;
	private Long tiempoRegistroMs;
	private Long tiempoConsultaMs;
	private Long tiempoIntervaloMs;
	private Boolean appHuellasVisible;

	public Long getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	public Long getTiempoRegistroMs() {
		return tiempoRegistroMs;
	}

	public void setTiempoRegistroMs(Long tiempoRegistroMs) {
		this.tiempoRegistroMs = tiempoRegistroMs;
	}

	public Long getTiempoConsultaMs() {
		return tiempoConsultaMs;
	}

	public void setTiempoConsultaMs(Long tiempoConsultaMs) {
		this.tiempoConsultaMs = tiempoConsultaMs;
	}

	public Long getTiempoIntervaloMs() {
		return tiempoIntervaloMs;
	}

	public void setTiempoIntervaloMs(Long tiempoIntervaloMs) {
		this.tiempoIntervaloMs = tiempoIntervaloMs;
	}

	public Boolean getAppHuellasVisible() {
		return appHuellasVisible;
	}

	public void setAppHuellasVisible(Boolean appHuellasVisible) {
		this.appHuellasVisible = appHuellasVisible;
	}
}
