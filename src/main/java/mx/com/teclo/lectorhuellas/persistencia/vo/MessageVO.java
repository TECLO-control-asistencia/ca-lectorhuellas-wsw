package mx.com.teclo.lectorhuellas.persistencia.vo;

public class MessageVO {
	private String mensaje;
	private Boolean conectado;
	private byte[] imagen;
	private byte[] template;

	public MessageVO() {
	}

	public MessageVO(final String mensaje, final Boolean conectado, final byte[] imagen , final byte[] template) {

		this.mensaje = mensaje;
		this.conectado = conectado;
		this.imagen = imagen;
		this.template = template;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Boolean getConectado() {
		return conectado;
	}

	public void setConectado(Boolean conectado) {
		this.conectado = conectado;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public byte[] getTemplate() {
		return template;
	}

	public void setTemplate(byte[] template) {
		this.template = template;
	}

}
