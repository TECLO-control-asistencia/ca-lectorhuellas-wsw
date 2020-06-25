package mx.com.teclo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import mx.com.teclo.lectorhuellas.negocio.services.JnlpService;

public class HttpHandshakeInterceptor implements HandshakeInterceptor {

	@Autowired
	private JnlpService jnlpService;

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			String ipAddress = servletRequest.getServletRequest().getHeader("X-FORWARDED-FOR");
			if (ipAddress == null) {
				ipAddress = servletRequest.getServletRequest().getRemoteAddr();
			}

			Long idDispositivo = jnlpService.crearDispositivoByIp(ipAddress);
			attributes.put("dispositivoId", idDispositivo);

		}
		return true;
	}

}