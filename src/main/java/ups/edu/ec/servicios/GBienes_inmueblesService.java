package ups.edu.ec.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.Negocio.GestionBienes_inmuebles;
import ups.edu.ec.modelo.Bienes_inmuebles;

@Path("bienes")
public class GBienes_inmueblesService {

	@Inject
	private GestionBienes_inmuebles gBienes_inmuebles;
	
	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Bienes_inmuebles misDatos() {
		Bienes_inmuebles bi1 = new Bienes_inmuebles();
		bi1.setId("1");
		bi1.setNombre("Mesa");
		bi1.setCantidad(150);
		bi1.setPrecio(45);
		return bi1;
	}
	
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarBienes(Bienes_inmuebles bien) {
		try {
			gBienes_inmuebles.guardarBienes(bien);
			return Response.status(Response.Status.OK).entity(bien).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	@GET
	@Path("bienesListar")
	@Produces("application/json")
	public List<Bienes_inmuebles> listarClientes() {	
		return gBienes_inmuebles.listarBienes();
	}
	
}
