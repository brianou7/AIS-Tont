package rest.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Bird;

@Path("/birds")
public class birds {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tont");

	@GET
	@Path("/list")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@SuppressWarnings("unchecked")
	public List<Bird> all() {
		EntityManager manager = factory.createEntityManager();		
		List<Bird> birds = (List<Bird>) manager.createQuery("FROM Bird").getResultList();
		
		System.out.print(birds);
		return birds;
	}
	
	@POST
	@Path("/filter")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@SuppressWarnings("unchecked")
	public List<Bird> filter(String arg) {
		System.out.print(arg);
		arg = "3";
		EntityManager manager = factory.createEntityManager();
		// Filter to both fields common and scientific names
		Query query = manager.createQuery("FROM Bird b WHERE b.common_name LIKE '%:arg%' OR b.scientific_name LIKE '%:arg%'");
		query.setParameter("arg", arg);
		List<Bird> birds = (List<Bird>) query.getResultList();
		
		System.out.print(birds);
		return birds;
	}
	
	@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String create(Bird bird) {
		EntityManager manager = factory.createEntityManager();		
		manager.getTransaction().begin();
		manager.persist(bird);
		manager.getTransaction().commit();
		manager.close();
		return "Bird created correctly";
	}

}
