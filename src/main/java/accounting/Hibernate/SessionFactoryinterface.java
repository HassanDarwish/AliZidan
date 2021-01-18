package accounting.Hibernate;

import java.io.IOException;

import org.hibernate.SessionFactory;

import accounting.enums.constants;

public interface SessionFactoryinterface {
	public SessionFactory getsSessionFactory(constants database) throws ClassNotFoundException, IOException ;

}
