package fi.agileo.javaee.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;

public class RuokailuApp extends ResourceConfig {

	public RuokailuApp() {
		packages("fi.agileo.javaee");
	}
}
