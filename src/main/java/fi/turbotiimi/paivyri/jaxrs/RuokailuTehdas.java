package fi.turbotiimi.paivyri.jaxrs;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import fi.turbotiimi.paivyri.databaseManagement.RuokailuDAO;
import fi.turbotiimi.paivyri.databaseManagement.RuokailuDTO;
import fi.turbotiimi.paivyri.service.RuokailuService;

@Stateless
@Path("/ruokailu")
public class RuokailuTehdas {
		
		public RuokailuTehdas() {}
		
		@Autowired
		private RuokailuService ruokailuService;
		
		// Tällä palautetaan kaikki ruokailuoliot listana tietokannasta
		@GET
		@Path("/")
		@Produces(MediaType.APPLICATION_JSON)
		public List<RuokailuDTO> findAll() {
			RuokailuDAO ruokailuDao = new RuokailuDAO();
			List<RuokailuDTO> ruokailuList = ruokailuDao.findAll();
			return ruokailuList;
		}
		
		// Tällä palautetaan ruokailuolioita listana henkilön nimen perusteella
		@GET
		@Path("/{username}")
		@Produces(MediaType.APPLICATION_JSON)
		public List<RuokailuDTO> findByUser(@PathParam("username") String username) {
			RuokailuDAO ruokailuDao = new RuokailuDAO();
			List<RuokailuDTO> ruokailuList = ruokailuDao.findByID(username);
			return ruokailuList;
		}

}
