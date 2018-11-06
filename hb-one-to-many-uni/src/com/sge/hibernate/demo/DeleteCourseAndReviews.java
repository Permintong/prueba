package com.sge.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sge.hibernate.demo.entity.Course;
import com.sge.hibernate.demo.entity.Instructor;
import com.sge.hibernate.demo.entity.InstructorDetail;
import com.sge.hibernate.demo.entity.Review;

public class DeleteCourseAndReviews {

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
			session.beginTransaction();

			int theId = 10;
			Course tempCourse = 
					session.get(Course.class, theId);
			
			
				System.out.println("Deleting: " + tempCourse.getTitle());
				if(tempCourse.getInstructor()!=null) {
					tempCourse.setInstructor(null);
				}
				session.delete(tempCourse);				
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {

		

			factory.close();
		}
	}
}
