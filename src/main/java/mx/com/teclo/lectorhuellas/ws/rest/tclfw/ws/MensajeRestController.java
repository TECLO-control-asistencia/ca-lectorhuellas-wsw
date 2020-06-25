package mx.com.teclo.lectorhuellas.ws.rest.tclfw.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.lectorhuellas.persistencia.vo.MessageVO;
import mx.com.teclo.lectorhuellas.persistencia.vo.MsgRespuestaVO;

@RestController
@RequestMapping("/mensaje")
public class MensajeRestController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/message")
	public void handleRequest(String request, @Header("simpSessionId") String sessionId) {
		MessageVO response = new MessageVO();
		response.setMensaje("");
		messagingTemplate.convertAndSend("/queue/reply-" + sessionId, response);
	}

	@MessageMapping("/peticion")
	public void ping(@DestinationVariable("userName") String userName, SimpMessageHeaderAccessor accessor)
			throws Exception {
		messagingTemplate.convertAndSend("/queue/" + userName + "/messages", null, accessor.toMap());
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/respuesta", consumes = "application/json", produces = "application/json")
	public ResponseEntity responder(@RequestBody MsgRespuestaVO respuesta) {
		messagingTemplate.convertAndSend("/queue/reply-" + respuesta.getIdCanal(), respuesta.getMensaje());
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
