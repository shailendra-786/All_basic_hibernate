package hibernate_rev.shailu;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_rev.shailu.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SessionFactory session = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session f = session.getCurrentSession();
		f.beginTransaction();

//        f.save(new Student("rohit","sharma","zero@gamail"));
//        Student s =f.get(Student.class, 1);
//        s.setFirst_name("hitman1");
//        f.delete(s);
//        Student s = (Student) f.createQuery("from Student where id=2").getSingleResult();
//        System.out.println(s.getEmail());
//        f.createQuery("update Student set email='hitman@'").executeUpdate();
//        String hql ="from Student where id=:id ";
//        String hql ="from Student where id= ?0 ";
//        Query q = f.createQuery(hql);
//        q.setParameter("id", 2);
//        q.setParameter(0, 2);
//        Student s =(Student) q.getSingleResult();
//        System.out.println(s.getFirst_name());

//        String nativeQuery = "select * from Student where id=:id";
//        Query q = f.createNativeQuery(nativeQuery,Student.class);
//        q.setParameter("id", 2);
//        Student s =(Student) q.getSingleResult();
//        System.out.println(s.getFirst_name());
		Student s = f.get(Student.class, 2); // return null if data is not there. execute right away
		Student s1 = f.load(Student.class, 2); // throws error if data is not present in db . return proxy obj
//        System.out.println(s);
//        System.out.println(s);
		f.getTransaction().commit();

	}
}
