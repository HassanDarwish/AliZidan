package accounting.Hibernate;

import org.hibernate.SessionFactory;

import accounting.enums.constants;

public interface SessionFactoryinterface {
	public SessionFactory getsSessionFactory(constants database) ;

}
