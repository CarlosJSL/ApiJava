package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Book;

public class HibernateUtils {
	private static Configuration configuration;
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static String url;
	private static String passw;
	private static String user;

	private synchronized static final SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				configuration = new Configuration();
				setSettingsContext();
				
				configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
				configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
				configuration.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
				configuration.setProperty("hibernate.current_session_context_class",
						"org.hibernate.context.internal.ThreadLocalSessionContext");

				configuration.setProperty("hibernate.c3p0.min_size", "0");
				configuration.setProperty("hibernate.c3p0.max_size", "1");
				configuration.setProperty("hibernate.c3p0.max_statements", "1");
				configuration.setProperty("hibernate.c3p0.maxIdleTime", "1");
				configuration.setProperty("hibernate.c3p0.acquireIncrement", "1");
				configuration.setProperty("hibernate.c3p0.initialPoolSize", "1");
				configuration.setProperty("hibernate.c3p0.maxIdleTimeExcessConnections", "1");
				configuration.setProperty("hibernate.show_sql", "true");
				configuration.setProperty("hibernate.format_sql", "true");
				configuration.setProperty("hibernate.hbm2ddl.auto", "update");

				configuration.setProperty("hibernate.connection.url", url);
				configuration.setProperty("hibernate.connection.username", user);
				configuration.setProperty("hibernate.connection.password", passw);

				configuration.addAnnotatedClass(Book.class);
				return configuration.buildSessionFactory();
			} else {
				return sessionFactory;
			}
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public synchronized static final Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public synchronized static final void setSettingsContext() {
		ReadPropertyFile property = new ReadPropertyFile();
		url = property.getUrlDb();
		passw = property.getPasswordDb();
		user = property.getUsernameDb();
	}
}
