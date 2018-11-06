package com.sge.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sge.hibernate.demo.entity.Course;
import com.sge.hibernate.demo.entity.Instructor;
import com.sge.hibernate.demo.entity.InstructorDetail;
import com.sge.hibernate.demo.entity.Review;

public class CreateCourseAndReview {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
		
			Course tempCourse1 =new Course("Boooooootstrap");
			Review tempReview1 = new Review("Le doy mis dieses");
			Review tempReview2 = new Review("Me parece una puta mierda");
			
			Course tempCourse2 =new Course("Curso de suisidio");
			Review tempReview3 = new Review("Estrá de muerte");
			Review tempReview4 = new Review("Me muero por volver a hacer algo parecido");

			// create some courses
			
			// add courses to instructor
			tempCourse1.add(tempReview1);
			tempCourse1.add(tempReview2);
			tempCourse2.add(tempReview3);
			tempCourse2.add(tempReview4);

			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			// add clean up code
			// session.close();

			factory.close();
		}
	}
}
