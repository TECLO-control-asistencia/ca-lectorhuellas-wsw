package mx.com.teclo.lectorhuellas.persistencia.vo;

public class MsgRespuestaVO {
	private String idCanal;
	private MessageVO mensaje;

	public String getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	public MessageVO getMensaje() {
		return mensaje;
	}

	public void setMensaje(MessageVO mensaje) {
		this.mensaje = mensaje;
	}

}
