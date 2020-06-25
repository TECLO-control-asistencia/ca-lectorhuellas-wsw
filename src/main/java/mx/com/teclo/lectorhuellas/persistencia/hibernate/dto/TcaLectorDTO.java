package mx.com.teclo.lectorhuellas.persistencia.hibernate.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "TCA062C_CA_LECTOR")
public class TcaLectorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3146661223283870989L;

	private static final String QUERY_IS_RUNNING = "CASE WHEN FH_ULTIMO_PING IS NULL THEN 0 ELSE CASE WHEN TRUNC((FH_ULTIMO_PING + numToDSInterval(60, 'second')), 'MI') < TRUNC(CURRENT_TIMESTAMP, 'MI') THEN 0 ELSE 1 END END";

	@Id
	@SequenceGenerator(name = "SQCA062C_CA_LECTOR", sequenceName = "SQTCA062C_CA_LECTOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQCA062C_CA_LECTOR")
	@Column(name = "ID_LECTOR", unique = true, nullable = false)
	private Long idLector;

	@Column(name = "NB_IP", unique = true, nullable = false)
	private String nbIp;

	@Column(name = "ST_ACTIVO", nullable = false)
	private Boolean stActivo;

	@Column(name = "NB_URL_JNLP")
	private String nbUrlJnlp;

	@Column(name = "idCanal")
	private String idCanal;

	@Column(name = "FH_ULTIMO_PING")
	private Date fhUltimoPing;

	@Column(name = "ID_USR_CREACION", nullable = false)
	private Long idUsrCreacion;

	@Column(name = "FH_CREACION", nullable = false)
	private Date fhCreacion;

	@Column(name = "ID_USR_MODIFICA", nullable = false)
	private Long idUsrModifica;

	@Column(name = "FH_MODIFICACION", nullable = false)
	private Date fhModificacion;

	@Formula(value = QUERY_IS_RUNNING)
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

	public Boolean getStActivo() {
		return stActivo;
	}

	public void setStActivo(Boolean stActivo) {
		this.stActivo = stActivo;
	}

	public String getNbUrlJnlp() {
		return nbUrlJnlp;
	}

	public void setNbUrlJnlp(String nbUrlJnlp) {
		this.nbUrlJnlp = nbUrlJnlp;
	}

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public Date getFhUltimoPing() {
		return fhUltimoPing;
	}

	public void setFhUltimoPing(Date fhUltimoPing) {
		this.fhUltimoPing = fhUltimoPing;
	}

	public Long getIdUsrCreacion() {
		return idUsrCreacion;
	}

	public void setIdUsrCreacion(Long idUsrCreacion) {
		this.idUsrCreacion = idUsrCreacion;
	}

	public Date getFhCreacion() {
		return fhCreacion;
	}

	public void setFhCreacion(Date fhCreacion) {
		this.fhCreacion = fhCreacion;
	}

	public Long getIdUsrModifica() {
		return idUsrModifica;
	}

	public void setIdUsrModifica(Long idUsrModifica) {
		this.idUsrModifica = idUsrModifica;
	}

	public Date getFhModificacion() {
		return fhModificacion;
	}

	public void setFhModificacion(Date fhModificacion) {
		this.fhModificacion = fhModificacion;
	}

	public Boolean getRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

}
