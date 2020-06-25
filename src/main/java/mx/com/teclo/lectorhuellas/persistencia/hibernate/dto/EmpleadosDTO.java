package mx.com.teclo.lectorhuellas.persistencia.hibernate.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class EmpleadosDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7097439603538693673L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID", unique = true, nullable = false)
	private Long empId;

	@Column(name = "EMP_COD")
	private String empCod;

	@Column(name = "EMP_PLACA")
	private String empPlaca;

	@Column(name = "EMP_TIP_ID")
	private Long empTipId;

	@Column(name = "EMP_RFC")
	private String empRFC;

	@Column(name = "AGRP_ID")
	private Long agrpId;

	@Column(name = "SEC_ID")
	private Long secId;

	@Column(name = "EMP_APE_PATERNO")
	private String empApePaterno;

	@Column(name = "EMP_APE_MATERNO")
	private String empApeMaterno;

	@Column(name = "EMP_NOMBRE")
	private String empNombre;

	@Column(name = "EMP_PWD")
	private String empPwd;

	@Column(name = "EMP_STATUS")
	private String empStatus;

	@Column(name = "CREADO_POR")
	private Long creadoPor;

	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "MODIFICADO_POR")
	private Long modificadoPor;

	@Column(name = "ULTIMA_MODIFICACION")
	private Date ultimaModificacion;

	@Column(name = "FH_INGRESO")
	private Date fechaIngreso;

	@Column(name = "FH_BAJA")
	private Date fechaBaja;

	@Column(name = "NUM_EMPLEADO")
	private String numEmpleados;
	//
	// @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "TSEG_USUARIO_APLICACION", schema = "ICD", joinColumns
	// = {
	// @JoinColumn(name = "USU_ID", nullable = false, updatable = false) },
	// inverseJoinColumns = {
	// @JoinColumn(name = "ID_APLICACION", nullable = false, updatable = false)
	// })
	// private List<AplicacionDTO> tsegCatAplicacioneses = new
	// ArrayList<AplicacionDTO>(0);
	//
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleadoDTO")
	// private List<PerfilUsuario> perfilUsuarios = new
	// ArrayList<PerfilUsuario>(0);
	//

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getNumEmpleados() {
		return numEmpleados;
	}

	public void setNumEmpleados(String numEmpleados) {
		this.numEmpleados = numEmpleados;
	}



	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the empCod
	 */
	public String getEmpCod() {
		return empCod;
	}

	/**
	 * @param empCod
	 *            the empCod to set
	 */
	public void setEmpCod(String empCod) {
		this.empCod = empCod;
	}

	/**
	 * @return the empPlaca
	 */
	public String getEmpPlaca() {
		return empPlaca;
	}

	/**
	 * @param empPlaca
	 *            the empPlaca to set
	 */
	public void setEmpPlaca(String empPlaca) {
		this.empPlaca = empPlaca;
	}

	public EmpleadosDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getEmpRFC() {
		return empRFC;
	}

	/**
	 * @param empRFC
	 *            the empRFC to set
	 */
	public void setEmpRFC(String empRFC) {
		this.empRFC = empRFC;
	}

	/**
	 * @return the empTipId
	 */
	public Long getEmpTipId() {
		return empTipId;
	}

	/**
	 * @param empTipId
	 *            the empTipId to set
	 */
	public void setEmpTipId(Long empTipId) {
		this.empTipId = empTipId;
	}

	/**
	 * @return the agrpId
	 */
	public Long getAgrpId() {
		return agrpId;
	}

	/**
	 * @param agrpId
	 *            the agrpId to set
	 */
	public void setAgrpId(Long agrpId) {
		this.agrpId = agrpId;
	}

	/**
	 * @return the secId
	 */
	public Long getSecId() {
		return secId;
	}

	/**
	 * @param secId
	 *            the secId to set
	 */
	public void setSecId(Long secId) {
		this.secId = secId;
	}

	/**
	 * @return the empApePaterno
	 */
	public String getEmpApePaterno() {
		return empApePaterno;
	}

	/**
	 * @param empApePaterno
	 *            the empApePaterno to set
	 */
	public void setEmpApePaterno(String empApePaterno) {
		this.empApePaterno = empApePaterno;
	}

	/**
	 * @return the empApeMaterno
	 */
	public String getEmpApeMaterno() {
		return empApeMaterno;
	}

	/**
	 * @param empApeMaterno
	 *            the empApeMaterno to set
	 */
	public void setEmpApeMaterno(String empApeMaterno) {
		this.empApeMaterno = empApeMaterno;
	}

	/**
	 * @return the empNombre
	 */
	public String getEmpNombre() {
		return empNombre;
	}

	/**
	 * @param empNombre
	 *            the empNombre to set
	 */
	public void setEmpNombre(String empNombre) {
		this.empNombre = empNombre;
	}

	/**
	 * @return the empPwd
	 */
	public String getEmpPwd() {
		return empPwd;
	}

	/**
	 * @param empPwd
	 *            the empPwd to set
	 */
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	/**
	 * @return the empStatus
	 */
	public String getEmpStatus() {
		return empStatus;
	}

	/**
	 * @param empStatus
	 *            the empStatus to set
	 */
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	/**
	 * @return the creadoPor
	 */
	public Long getCreadoPor() {
		return creadoPor;
	}

	/**
	 * @param creadoPor
	 *            the creadoPor to set
	 */
	public void setCreadoPor(Long creadoPor) {
		this.creadoPor = creadoPor;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the modificadoPor
	 */
	public Long getModificadoPor() {
		return modificadoPor;
	}

	/**
	 * @param modificadoPor
	 *            the modificadoPor to set
	 */
	public void setModificadoPor(Long modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	/**
	 * @return the ultimaModificacion
	 */
	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	/**
	 * @param ultimaModificacion
	 *            the ultimaModificacion to set
	 */
	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}
	/**
	 * @return the tsegCatAplicacioneses
	 */
	// public List<AplicacionDTO> getTsegCatAplicacioneses() {
	// return tsegCatAplicacioneses;
	// }
	// /**
	// * @param tsegCatAplicacioneses the tsegCatAplicacioneses to set
	// */
	// public void setTsegCatAplicacioneses(List<AplicacionDTO>
	// tsegCatAplicacioneses) {
	// this.tsegCatAplicacioneses = tsegCatAplicacioneses;
	// }
	// /**
	// * @return the perfilUsuarios
	// */
	// public List<PerfilUsuario> getPerfilUsuarios() {
	// return perfilUsuarios;
	// }
	// /**
	// * @param perfilUsuarios the perfilUsuarios to set
	// */
	// public void setPerfilUsuarios(List<PerfilUsuario> perfilUsuarios) {
	// this.perfilUsuarios = perfilUsuarios;
	// }
}
