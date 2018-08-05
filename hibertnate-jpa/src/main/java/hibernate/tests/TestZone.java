package hibernate.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate.models.Country;
import hibernate.models.Zone;

public class TestZone {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tont");; 

 	public static void main(String[] args) {
		/* Create the persistence manager  */
 		EntityManager manager = factory.createEntityManager();
		Zone zone = new Zone("Z1", "Zona Uno");
		Country country = new Country("CO", "Colombia");
		country.setZone(zone);
		
		manager.getTransaction().begin();
		manager.persist(zone);
		manager.persist(country);
		manager.getTransaction().commit();
		manager.close();
		
		showAll();
		
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		zone = manager.merge(zone);
		zone.setName("Zona Uno Actualizada otra vez");
//		manager.remove(zone);
		manager.getTransaction().commit();
		manager.close();
		
		showAll();
	}

	private static void initialInsert() {
		EntityManager manager = factory.createEntityManager();
		Zone zone = new Zone("Z1", "Zona Uno"); 
		
		manager.getTransaction().begin();
		manager.persist(zone);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	private static void showAll() {
		EntityManager manager = factory.createEntityManager();
		List<Zone> zones = (List<Zone>) manager.createQuery("FROM Zone").getResultList();
		System.out.println("Hay " + zones.size() + " zonas en el sistema.");
		
		for (Zone zone:zones) {
			 System.out.println(zone.toString());
		}
		
		List<Country> countries = (List<Country>) manager.createQuery("FROM Country").getResultList();
		System.out.println("Hay " + countries.size() + " paises en el sistema.");
		
		for (Country country:countries) {
			System.out.print(country.toString());
		}
	}
}
