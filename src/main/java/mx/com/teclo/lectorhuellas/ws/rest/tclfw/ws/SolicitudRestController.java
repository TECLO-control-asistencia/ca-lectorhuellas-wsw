package mx.com.teclo.lectorhuellas.ws.rest.tclfw.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.teclo.lectorhuellas.negocio.services.SolicitudService;
import mx.com.teclo.lectorhuellas.persistencia.vo.SolicitudLecturaVO;
import mx.com.teclomexicana.arquitectura.ortogonales.exception.NotFoundException;

@RestController
@RequestMapping("/solicitud")
public class SolicitudRestController {

	@Autowired
	private SolicitudService solicitudService;

	@GetMapping(value = "/ultima")
	public ResponseEntity<SolicitudLecturaVO> getSolicitud(@RequestParam(value = "idLector") Long idLector)
			throws NotFoundException {
		return new ResponseEntity<SolicitudLecturaVO>(solicitudService.getUltimaSolicitud(idLector), HttpStatus.OK);
	}

}
