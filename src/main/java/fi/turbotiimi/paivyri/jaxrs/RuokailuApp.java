package fi.turbotiimi.paivyri.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;

public class RuokailuApp extends ResourceConfig {

	public RuokailuApp() {
		packages("fi.turbotiimi.paivyri");
	}
}
