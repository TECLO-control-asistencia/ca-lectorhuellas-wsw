package mx.com.teclo.lectorhuellas.persistencia.vo;

import java.util.List;

public class SolicitudLecturaVO {
	private Long idSolicitud;
	private Long idEmpleado;
	private int tipoOperacion;
	private boolean respondido;
	private Long tiempoAtencion;
	private String idCanal;
	private List<HuellasVO> huellas;

	public Long getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public boolean isRespondido() {
		return respondido;
	}

	public void setRespondido(boolean respondido) {
		this.respondido = respondido;
	}

	public Long getTiempoAtencion() {
		return tiempoAtencion;
	}

	public void setTiempoAtencion(Long tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

	
	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public List<HuellasVO> getHuellas() {
		return huellas;
	}

	public void setHuellas(List<HuellasVO> huellas) {
		this.huellas = huellas;
	}

}
