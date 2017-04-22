package fi.agileo.javaee.jaxrs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fi.agileo.javaee.api.Ruokailu;

@Path("/ruokailu")
public class RuokailuTehdas {
	// Luodaan entitymanageri
		private EntityManagerFactory tehdas;
		private EntityManager entityManageri; 
		private EntityTransaction transaktio;
		
		public RuokailuTehdas() {
			this.tehdas = Persistence.createEntityManagerFactory("Ruokailu");
			this.entityManageri = tehdas.createEntityManager(); 
			this.transaktio = entityManageri.getTransaction();
		}
		
		@GET
		@Path("/{henkilo}")
		@Produces(MediaType.APPLICATION_JSON)
		public void findByHenkilo(@PathParam("henkilo") String henkilo) {
			//Ruokailu ruokailu = new Ruokailu();
			//ruokailu.setNimi("asd");
			String ruokailu = "Lollo";
			//return ruokailu;
		}

}
