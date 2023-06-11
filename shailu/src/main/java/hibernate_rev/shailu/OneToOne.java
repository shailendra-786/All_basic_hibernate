package hibernate_rev.shailu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate_rev.shailu.entity.Address;
import hibernate_rev.shailu.entity.User;

public class OneToOne {
	public static void main(String[] args) {
		Transaction tx = null;

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			tx = session.beginTransaction();
			User user = session.load(User.class, 1);
			System.out.println("data is "+user.getAddres().getCity());
			user.getAddres().setCity("Mumbai");
			tx.commit();
		} catch (Exception e) {
			System.out.println("Erorro "+e);
			if (tx != null) {
				tx.rollback();
			}
		}

		// saving data
//		try {
//			tx = session.beginTransaction();
//			User user = new User();
//			user.setUsername("shailendra");
//			Address address = new Address();
//			address.setStreet("siddheswar");
//			address.setCity("Thane");
//			address.setUser(user);
//			user.setAddres(address);
//			;
//
//			session.persist(user);
//			session.persist(address);
//			tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			System.out.println("Error----> " + e);
//		} finally {
//			session.flush();
//			session.close();
//		}
	}
}
