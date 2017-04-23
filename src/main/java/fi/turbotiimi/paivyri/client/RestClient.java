package fi.turbotiimi.paivyri.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.turbotiimi.paivyri.databaseManagement.RuokailuDTO;

public class RestClient {

	private static final Logger LOG = LoggerFactory.getLogger(RestClient.class);

	private WebTarget target;

	public RestClient() {
		Client client = ClientBuilder.newClient();
		//target = client.target("http://localhost:9080").path("rest").path("calculator");
		target = client.target("http://localhost:9080").path("paivyri");
	}

	public RuokailuDTO ruokailu(String henkilo) {
		try {
			Response response = target.path("ruokailu")
					.path(URLEncoder.encode(henkilo, "UTF-8"))
					.request(MediaType.APPLICATION_JSON_TYPE).get();
			return response.readEntity(RuokailuDTO.class);
		} catch (UnsupportedEncodingException e) {
			LOG.error("Request failed", e);
			return null;
		}
	}
	
}