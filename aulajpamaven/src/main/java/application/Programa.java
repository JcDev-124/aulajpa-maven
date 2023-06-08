package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquin", "joaquin@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "anamaria@gmail.com");

		
		EntityManagerFactory enf  = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = enf.createEntityManager();
		/*em.getTransaction().begin();
		em.persist(p1); // adiciona no bd
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();*/
		
		Pessoa p  = em.find(Pessoa.class, 2); // busca
		System.out.println(p); 
		
		em.getTransaction().begin(); 
		em.remove(p); // remove, sempre buscar antes
		em.getTransaction().commit();
		
		
		em.close();
		enf.close();
		System.out.println("Done!");
	}

}
