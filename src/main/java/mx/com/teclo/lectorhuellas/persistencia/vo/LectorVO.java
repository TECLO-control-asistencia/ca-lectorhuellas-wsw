package mx.com.teclo.lectorhuellas.persistencia.vo;

public class LectorVO {
	private Long idLector;
	private String nbIp;
	private String nbUrlJnlp;
	private Boolean stActivo;
	private Boolean running;

	public Long getIdLector() {
		return idLector;
	}

	public void setIdLector(Long idLector) {
		this.idLector = idLector;
	}

	public String getNbIp() {
		return nbIp;
	}

	public void setNbIp(String nbIp) {
		this.nbIp = nbIp;
	}

	public String getNbUrlJnlp() {
		return nbUrlJnlp;
	}

	public void setNbUrlJnlp(String nbUrlJnlp) {
		this.nbUrlJnlp = nbUrlJnlp;
	}

	public Boolean getStActivo() {
		return stActivo;
	}

	public void setStActivo(Boolean stActivo) {
		this.stActivo = stActivo;
	}

	public Boolean getRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

}
