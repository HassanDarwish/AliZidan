package accounting.Hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil_Mysql {

	
	private static SessionFactory sessionfactory;
	public static SessionFactory getsSessionFactory() throws ClassNotFoundException, IOException {
		
		if(sessionfactory==null) {
		
                Configuration configuration = new Configuration();
                File[] files = null;
		 		files = listfile();
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
	
	
	public static File[] listfile() throws IOException {
		
		List<String> classNames = new ArrayList<String>();
		ZipInputStream zip = new ZipInputStream(new FileInputStream("Aaaa.jar"));
		
			 int y=0;
			 
		for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
			 
		    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
		        // This ZipEntry represents a class. Now, what class does it represent?
		        String className = entry.getName().replace('/', '.'); // including ".class"
		        //System.out.println(className);
		        	if(className.contains("accounting.model.entity")) {
		        classNames.add(className.substring(0, className.length() - ".class".length()));
		         String[] names=className.split("accounting.model.entity.");
		   
		        y++;
		        	}
		    }
		}
		zip = new ZipInputStream(new FileInputStream("Aaaa.jar"));
		File[] files=new File[y];
		int u=0;
		for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
			 
		    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
		        // This ZipEntry represents a class. Now, what class does it represent?
		        String className = entry.getName().replace('/', '.'); // including ".class"
		        //System.out.println(className);
		        	if(className.contains("accounting.model.entity")) {
		        classNames.add(className.substring(0, className.length() - ".class".length()));
		         String[] names=className.split("accounting.model.entity.");
		        files[u]=new File(names[1]);
		        u++;
		        	}
		    }
		}
		return files;
	}
	
	public static File[]  list_Files() throws ClassNotFoundException {
		String packageName = "accounting.model.entity";
		List<Class> commands = new ArrayList<Class>();
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
