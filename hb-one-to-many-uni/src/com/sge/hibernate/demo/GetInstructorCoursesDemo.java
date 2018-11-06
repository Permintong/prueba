package com.sge.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sge.hibernate.demo.entity.Course;
import com.sge.hibernate.demo.entity.Instructor;
import com.sge.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				try {
					// start a transaction
					session.beginTransaction();
					
					// get the instructor from db
					int theId = 1;
					Instructor tempInstructor = session.get(Instructor.class, theId);
					for (Course cursito : tempInstructor.getCourses()) {
						System.out.println(cursito.toString());
					}
				} finally {
					
						factory.close();
				}

	}

}
