package mx.com.teclo.lectorhuellas.persistencia.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TCA060P_AD_PARAMETROS")
public class TcaParametrosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -98710923644880175L;


	@Id
	@Column(name = "ID_PARAMETRO", unique = true, nullable = false)
	private Long idParametro;

	@Column(name = "NB_AMBIENTE", nullable = false)
	private String nbAmbiente;

	@Column(name = "NU_MILISEG_REGISTRO", nullable = false)
	private Long nuMilisegRegistro;

	@Column(name = "NU_MILISEG_CONSULTA", nullable = false)
	private Long nuMilisegConsulta;

	@Column(name = "NU_MILISEG_INTERVALO", nullable = false)
	private Long nuMilisegIntervalo;

	@Column(name = "APP_HUELLAS_VISIBLE")
	private Boolean appHuellasVisible;

	public Long getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	public String getNbAmbiente() {
		return nbAmbiente;
	}

	public void setNbAmbiente(String nuAmbiente) {
		this.nbAmbiente = nuAmbiente;
	}

	public Long getNuMilisegRegistro() {
		return nuMilisegRegistro;
	}

	public void setNuMilisegRegistro(Long nuMilisegRegistro) {
		this.nuMilisegRegistro = nuMilisegRegistro;
	}

	public Long getNuMilisegConsulta() {
		return nuMilisegConsulta;
	}

	public void setNuMilisegConsulta(Long nuMilisegConsulta) {
		this.nuMilisegConsulta = nuMilisegConsulta;
	}

	public Long getNuMilisegIntervalo() {
		return nuMilisegIntervalo;
	}

	public void setNuMilisegIntervalo(Long nuMilisegIntervalo) {
		this.nuMilisegIntervalo = nuMilisegIntervalo;
	}

	public Boolean getAppHuellasVisible() {
		return appHuellasVisible;
	}

	public void setAppHuellasVisible(Boolean appHuellasVisible) {
		this.appHuellasVisible = appHuellasVisible;
	}

}
