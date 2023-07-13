package ups.edu.ec.Negocio;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.datos.Bienes_inmueblesDAO;
import ups.edu.ec.modelo.Bienes_inmuebles;

@Stateless
public class GestionBienes_inmuebles {

	@Inject
	private Bienes_inmueblesDAO daoBienes_inmuebles;
	
	public void guardarBienes(Bienes_inmuebles bien) throws Exception {
		if(!this.isCedulaValida(bien.getId()))
			throw new Exception("Id incorrecta");
		
		if(daoBienes_inmuebles.readString(bien.getId()) == null) {
			try {
				daoBienes_inmuebles.insert(bien);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoBienes_inmuebles.update(bien);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length() <= 1;
	}
	
	
	public List<Bienes_inmuebles> listarBienes(){
		return daoBienes_inmuebles.getAll();
	}
	
}
