package net.daneking.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(SpringConfig.class);
		Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(mvcContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}