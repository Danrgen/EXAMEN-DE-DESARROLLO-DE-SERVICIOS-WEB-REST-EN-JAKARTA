package ups.edu.ec.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.modelo.Bienes_inmuebles;

@Stateless
public class Bienes_inmueblesDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Bienes_inmuebles bien) {
		em.persist(bien);
	}
	
	public void update(Bienes_inmuebles bien) {
		em.merge(bien);
	}
	
	public Bienes_inmuebles readInt(int id) {
		Bienes_inmuebles p = em.find(Bienes_inmuebles.class, id);
		return p;
	}
	
	public Bienes_inmuebles readString(String id) {
		Bienes_inmuebles p = em.find(Bienes_inmuebles.class, id);
		return p;
	}
	
	public void delete(int codigo) {
		Bienes_inmuebles p = em.find(Bienes_inmuebles.class, codigo);
		em.remove(p);
	}
	
	public List<Bienes_inmuebles> getAll(){
		String jpql = "SELECT p FROM Bienes_inmuebles p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
	
}
