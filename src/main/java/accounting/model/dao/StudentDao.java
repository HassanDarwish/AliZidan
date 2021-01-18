package accounting.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import accounting.Hibernate.SessionFactoryAdapter;
import accounting.enums.constants;
import accounting.model.entity.student;
 
public class StudentDao {
    public void saveStudent(student student) {

        Transaction transaction = null;

        // auto close session object
        try (Session session = new SessionFactoryAdapter().getsSessionFactory(constants.Mysql).getCurrentSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(student);

            // commit transction
            transaction.commit();
        } catch (Exception e) {
        	System.out.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
  