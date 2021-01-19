package accounting.Hibernate;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil_Oracle {


private static SessionFactory sessionfactory;
public static SessionFactory getsSessionFactory() throws Exception {
		
		if(sessionfactory==null) {
			
                Configuration configuration = new Configuration();
                File[] files= list_Files();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/alizidan?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                
                String packageName = "accounting.model.entity";

        		// Find classes implementing ICommand.
        		for (File file : files) {
        		    String className = file.getName().replaceAll(".class$", "");
        		    Class<?> cls = Class.forName(packageName + "." + className);
        		    configuration.addAnnotatedClass(cls);     
        		}
        		
/*
                configuration.addAnnotatedClass(Student.class);
*/
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionfactory = configuration.buildSessionFactory(serviceRegistry);
             
		}
		
		
		return sessionfactory;
		
	}

	public static File[]  list_Files() throws ClassNotFoundException {
		String packageName = "accounting.model.entity";
		 
		URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));

		// Filter .class files.
		File[] files = new File(root.getFile()).listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".class");
		    }
		});

	return files;
	}
	
	
}
