package mx.com.teclo.lectorhuellas.ws.rest.tclfw.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.lectorhuellas.negocio.services.JnlpService;
import mx.com.teclomexicana.arquitectura.ortogonales.exception.NotFoundException;

@RestController
@RequestMapping("/lector")
public class PingRestController {

	@Autowired
	private JnlpService jnlpService;

	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/ping")
	public ResponseEntity ping(@RequestParam(value = "idLector") Long idLector) throws NotFoundException {
		jnlpService.savePing(idLector);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

}
