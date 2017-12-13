package com.ipartek.pruebaHibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration()
				.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/colegio2")
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.username", "root")
				.setProperty("hibernate.connection.password", "root")
				.setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.current_session_context_class", "thread")
				.setProperty("hibernate.hbm2ddl.auto", "update")
				.addAnnotatedClass(Alumno.class)
				.addAnnotatedClass(Direccion.class)
				.addAnnotatedClass(Coche.class)
				.addAnnotatedClass(Asignatura.class);
		
		SessionFactory sf = cfg.buildSessionFactory();

		Session s = sf.getCurrentSession();

		s.beginTransaction();
		
		EntityManager entityManager = s.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		List<Alumno> alumnos = entityManager.createQuery("from Alumno").getResultList();
		/*Direccion d = new Direccion("Calle falsa", "48001", "Catalunya");
		
		Alumno a = new Alumno("Alberto","GDC", "666666666", "a@a.com", new Date(), d);
		
		entityManager.persist(a);
		
		a.setApellidos("Garcia de Cortazar");
		
		a.setEmail("b@b.com");*/
		
		/*CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Alumno> criteria = builder.createQuery(Alumno.class);
		
		Root<Alumno> alumno = criteria.from(Alumno.class);
		
		criteria.select(alumno);
		
		criteria.where(builder.like(alumno.<String>get("nombre"), "%b%"));
		
		List<Alumno> alumnos = entityManager.createQuery(criteria).getResultList();*/
		
		for(Alumno a: alumnos) {
			System.out.println(a.getNombre());
			System.out.println(a.getDireccion().getDireccion());
			for(Coche c : a.getCoches()) {
				System.out.println(c.getModelo());
			}
			
			for(Asignatura asi: a.getAsignaturas()) {
				System.out.println(asi.getNombre());
			}
		}
		
		entityManager.getTransaction().commit();
		
		s.getTransaction().commit();
		
		
		s.close();
		
		sf.close();
		


	}
}
