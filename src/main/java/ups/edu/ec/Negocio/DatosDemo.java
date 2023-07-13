package ups.edu.ec.Negocio;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.datos.Bienes_inmueblesDAO;
import ups.edu.ec.modelo.Bienes_inmuebles;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private Bienes_inmueblesDAO daoBienes_inmuebles;
	
	
	@PostConstruct
	public void init() {
		
		Bienes_inmuebles bi1 = new Bienes_inmuebles();
		bi1.setId("1");
		bi1.setNombre("Silla");
		bi1.setCantidad(200);
		bi1.setPrecio(10);
		daoBienes_inmuebles.insert(bi1);
		
		Bienes_inmuebles bi2 = new Bienes_inmuebles();
		bi2.setId("2");
		bi2.setNombre("Armario");
		bi2.setCantidad(75);
		bi2.setPrecio(70);
		daoBienes_inmuebles.insert(bi2);
		
		List<Bienes_inmuebles> bienes = daoBienes_inmuebles.getAll();
		for(Bienes_inmuebles bi: bienes) {
			System.out.println(bi);
		}
		
	}
}
