package fi.agileo.javaee.jaxrs;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import fi.agileo.javaee.databaseManagement.RuokailuDTO;
import fi.agileo.javaee.service.RuokailuService;

@Path("/ruokailu")
public class RuokailuTehdas {
		
		public RuokailuTehdas() {}
		
		@Autowired
		private RuokailuService ruokailuService;
		
		// Tällä palautetaan kaikki ruokailuoliot listana tietokannasta
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<RuokailuDTO> findAll() {
			List<RuokailuDTO> ruokailuList = ruokailuService.findAll();
			return ruokailuList;
		}
		
		// Tällä palautetaan ruokailuolioita listana henkilön nimen perusteella
		@GET
		@Path("/{username}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<RuokailuDTO> findByUser(@PathParam("username") String username) {
			List<RuokailuDTO> ruokailuList = ruokailuService.findByID(username);
			return ruokailuList;
		}

}
