//package schoolsystem.mm;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import schoolsystem.mm.entity.Course;
//import schoolsystem.mm.entity.Student;
//
//@Repository
//public class Main {
//
//	@Autowired
//	private static SessionFactory sessionFactory; 
//	
//	public static void main(String[] args) {
//
//		// create session factory
////		SessionFactory factory = new Configuration()
////								.configure("hibernate.cfg.xml")
////								.addAnnotatedClass(Teacher.class)
////								.addAnnotatedClass(TeacherDetail.class)
////								.addAnnotatedClass(Course.class)
//////								.addAnnotatedClass(Review.class)
////								.addAnnotatedClass(Student.class)
////								.buildSessionFactory();
//	
//		
//		
//		Session session = sessionFactory.getCurrentSession();
//		
//		try {			
//			session.beginTransaction();
//			
//			Course tempCourse = new Course(); 	
//			System.out.println("\nSaving the course");
//			session.save(tempCourse); 
//			
//			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
//			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
//			
//			tempCourse.addStudent(tempStudent1);
//			tempCourse.addStudent(tempStudent2);
//			
//			System.out.println("\nSaving students...");
//			session.save(tempStudent1);
//			session.save(tempStudent2);
//			System.out.println("Saved students: " + tempCourse.getStudents());
//			
//			session.getTransaction().commit();
//			System.out.println("Done!");
//			
//		}
//		finally {
//			session.close(); 
////			factory.close();
//		}
//	}
//
//}