package mx.com.teclo.lectorhuellas.persistencia.hibernate.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TCA061D_CA_SOLICITUD")
public class SolicitudDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SQCA061D_CA_SOLICITUD", sequenceName = "SQTCA061D_CA_SOLICITUD", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQCA061D_CA_SOLICITUD")
	@Column(name = "ID_SOLICITUD", unique = true, nullable = false)
	private Long idSolicitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPLEADO")
	private EmpleadosDTO empleadoDTO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LECTOR")
	private TcaLectorDTO lectorDTO;

	@Column(name = "CD_OPERACION")
	private int cdOperacion;
	
	@Column(name = "CD_DEDO")
	private Integer cdDedo;



	@Column(name = "FH_CREACION")
	private Date fechaCreacion;
	
	@Column(name = "FH_ATENCION")
	private Date fechaAtencion;

	
	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public EmpleadosDTO getEmpleadoDTO() {
		return empleadoDTO;
	}

	public void setEmpleadoDTO(EmpleadosDTO empleadoDTO) {
		this.empleadoDTO = empleadoDTO;
	}

	public TcaLectorDTO getLectorDTO() {
		return lectorDTO;
	}

	public void setLectorDTO(TcaLectorDTO lectorDTO) {
		this.lectorDTO = lectorDTO;
	}

	public int getCdOperacion() {
		return cdOperacion;
	}

	public void setCdOperacion(int cdOperacion) {
		this.cdOperacion = cdOperacion;
	}

	public Integer getCdDedo() {
		return cdDedo;
	}

	public void setCdDedo(Integer cdDedo) {
		this.cdDedo = cdDedo;
	}	

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

}