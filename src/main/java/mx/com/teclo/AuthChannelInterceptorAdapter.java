package mx.com.teclo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

import mx.com.teclo.lectorhuellas.negocio.services.JnlpService;
import mx.com.teclomexicana.arquitectura.ortogonales.exception.BusinessException;

public class AuthChannelInterceptorAdapter extends ChannelInterceptorAdapter {

	@Autowired
	private JnlpService jnlpService;

	public AuthChannelInterceptorAdapter() {
	}

	@Override
	public Message<?> preSend(final Message<?> message, MessageChannel channel) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

		accessor.removeNativeHeader("user");

		if (accessor.getMessageType() == SimpMessageType.CONNECT) {
			try {
				updateChannel(accessor.getSessionAttributes(), accessor.getSessionId());
			} catch (BusinessException e) {
				System.out.println("ERROR");
			}
		} else if (accessor.getMessageType() == SimpMessageType.DISCONNECT) {
			try {
				updateChannel(accessor.getSessionAttributes(), null);
			} catch (BusinessException e) {
				System.out.println("ERROR");
			}
		}
		return message;
	}

	/**
	 * Guarda el ID del canal de comunicación que debe usar el lector de huellas
	 * 
	 * @param attributesMap
	 * @param sessionId
	 * @throws BusinessException
	 */
	private void updateChannel(Map<String, Object> attributesMap, String sessionId) throws BusinessException {
		String idDispositivo = "";

		if (attributesMap != null && !attributesMap.isEmpty() && attributesMap.keySet().contains("dispositivoId")) {
			for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
				if (entry.getKey().equals("dispositivoId")) {
					idDispositivo = entry.getValue().toString();
					break;
				}
			}
			jnlpService.saveSessionHandShake(new Long(idDispositivo), sessionId);
		} else {
			throw new BusinessException("Lector no identificado");			
		}
	}
}
