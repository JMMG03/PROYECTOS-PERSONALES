package org.example.util;

import java.util.Properties;

import org.example.model.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static String hibernateType = "file";
	public static String database = "h2";
	private static SessionFactory sessionFactory;

	public static Session newSession() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate-" + hibernateType + "-" + database + ".cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed. Using default values." + ex);

				Configuration configuration = new Configuration();

				Properties props = new Properties();
				props.put("hibernate.connection.driver_class", "org.h2.Driver");
				props.put("hibernate.connection.url", "jdbc:h2:file:./defaultDB");
				props.put("hibernate.connection.username", "sa");
				props.put("hibernate.connection.password", "1234");
				props.put("hibernate.current_session_context_class", "thread");

				configuration.setProperties(props);
				configuration.addAnnotatedClass(Estudiante.class);
				sessionFactory = configuration.buildSessionFactory();
				// throw new ExceptionInInitializerError(ex);
			}
		}
		return sessionFactory.openSession();
	}
}