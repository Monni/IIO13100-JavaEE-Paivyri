package fi.agileo.javaee.jaxrs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fi.agileo.javaee.api.Ruokailu;

@Path("/ruokailu")
public class RuokailuTehdas {
		
		public RuokailuTehdas() {}
		
		// Tällä palautetaan kaikki ruokailuoliot listana tietokannasta
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Ruokailu> findAll() {
			// TODO Tähän pyydetään DAOsta kaikki
			List<Ruokailu> ruokailuList = null;
			
			return ruokailuList;
		}
		
		// Tällä palautetaan ruokailuolioita listana henkilön nimen perusteella
		@GET
		@Path("/{henkilo}")
		@Produces(MediaType.APPLICATION_JSON)
		public String findByHenkilo(@PathParam("henkilo") String henkilo) {
			//Ruokailu ruokailu = new Ruokailu();
			//ruokailu.setNimi("asd");
			String ruokailu = "Lollo";
			return ruokailu;
		}

}
