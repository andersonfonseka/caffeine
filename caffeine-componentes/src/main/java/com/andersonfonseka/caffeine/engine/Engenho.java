package com.andersonfonseka.caffeine.engine;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class Engenho {

	private VelocityEngine ve = new VelocityEngine();
	private Template template;
	private VelocityContext context = new VelocityContext();
	private String templateName;
	
	public Engenho(String templateName) {
		
		this.templateName = templateName;
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		
		Properties props = new Properties();
		props.put("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
		props.put("runtime.log.logsystem.log4j.category", "velocity");
		props.put("runtime.log.logsystem.log4j.logger", "velocity");
		
		ve.init(props);
		
		this.template = ve.getTemplate("templates/" + this.templateName);

	}
	
	public void putOnContext(String key, Object value){
		this.context.put(key, value);		
	}
	
	public String execute() {
		
		StringWriter writer = new StringWriter();
		this.template.merge(context, writer);
		return writer.toString().replace("*", "").trim();
	}
	
}

