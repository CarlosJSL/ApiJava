package config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

public class ApplicationJAXRS extends Application {
	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("jersey.config.server.provider.packages", "service");
		return properties;
	}

	@Override
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<>();
		singletons.add(new JacksonFeature());
		// singletons.add(new TokenAuth());
		// singletons.add(new CorsFilter());
		return singletons;
	}
}
