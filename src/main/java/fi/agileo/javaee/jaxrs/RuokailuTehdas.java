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

import org.springframework.beans.factory.annotation.Autowired;

import fi.agileo.javaee.api.Ruokailu;
import fi.agileo.javaee.service.RuokailuService;

@Path("/ruokailu")
public class RuokailuTehdas {
		
		public RuokailuTehdas() {}
		
		@Autowired
		private RuokailuService ruokailuService;
		
		// Tällä palautetaan kaikki ruokailuoliot listana tietokannasta
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Ruokailu> findAll() {
			List<Ruokailu> ruokailuList = ruokailuService.findAll();
			return ruokailuList;
		}
		
		// Tällä palautetaan ruokailuolioita listana henkilön nimen perusteella
		@GET
		@Path("/{username}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Ruokailu> findByUser(@PathParam("username") String username) {
			List<Ruokailu> ruokailuList = ruokailuService.findByUser(username);
			return ruokailuList;
		}

}
