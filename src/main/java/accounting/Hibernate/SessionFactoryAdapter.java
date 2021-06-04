package accounting.Hibernate;

import org.hibernate.SessionFactory;

import accounting.enums.constants;

public   class SessionFactoryAdapter implements SessionFactoryinterface{

	public   SessionFactory getsSessionFactory(constants database) throws Exception {
		// TODO Auto-generated method stub
		SessionFactory sessionfacrory = null;
		
		switch (database) {
        case Mysql:
         	sessionfacrory= HibernateUtil_Mysql.getsSessionFactory();
        	break;
        case Oracle:
        	sessionfacrory= HibernateUtil_Oracle.getsSessionFactory();
        	break;
		case Main_Saceen_Menu:
			break;
		case jtree_accounts:
			break;
		default:
			break;
       
		}
	/*	if(database.equals(constants.Mysql)) {
			return HibernateUtil_Mysql.getsSessionFactory();
		}
		*/
		
		return sessionfacrory;
	}

}
