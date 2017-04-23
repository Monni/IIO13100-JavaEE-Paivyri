package fi.agileo.javaee.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.agileo.javaee.api.Ruokailu;

public class RestClient {

	private static final Logger LOG = LoggerFactory.getLogger(RestClient.class);

	private WebTarget target;

	public RestClient() {
		Client client = ClientBuilder.newClient();
		//target = client.target("http://localhost:9080").path("rest").path("calculator");
		target = client.target("http://localhost:9080").path("paivyri");
	}

	public Ruokailu ruokailu(String henkilo) {
		try {
			Response response = target.path("ruokailu")
					.path(URLEncoder.encode(henkilo, "UTF-8"))
					.request(MediaType.APPLICATION_JSON_TYPE).get();
			return response.readEntity(Ruokailu.class);
		} catch (UnsupportedEncodingException e) {
			LOG.error("Request failed", e);
			return null;
		}
	}
	
	/*
	public Calculation calc(String op, int left, int right) {
		try {
			Response response = target.path("calc")
					.path(URLEncoder.encode(op, "UTF-8"))
					.path(URLEncoder.encode(Integer.toString(left), "UTF-8"))
					.path(URLEncoder.encode(Integer.toString(right), "UTF-8"))
					.request(MediaType.APPLICATION_JSON_TYPE).get();
			return response.readEntity(Calculation.class);
		} catch (UnsupportedEncodingException e) {
			LOG.error("Request failed", e);
			return null;
		}
	}
*/
	/*public Calculation calc2(Calculation in) {
		Response response = target.path("calcform")
				.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(in));
		return response.readEntity(Calculation.class);
	}*/




}