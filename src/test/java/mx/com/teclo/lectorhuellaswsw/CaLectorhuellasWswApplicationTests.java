package mx.com.teclo.lectorhuellaswsw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.teclo.arquitectura.ortogonales.seguridad.service.webservice.WSService;
import mx.com.teclo.arquitectura.ortogonales.seguridad.vo.webservice.WSInfoVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaLectorhuellasWswApplicationTests {
	
	@Autowired
	private WSService wsService;
	
	@Value("${ws.code}")
	private String codeApplication;

	@Test
	public void contextLoads() {
		WSInfoVO response = wsService.webServiceInfo(codeApplication);
		if(response != null) {
			System.out.println("OK");
		}
	}

}
