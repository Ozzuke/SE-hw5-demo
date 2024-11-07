package ee.ut.tvt.hibernateDemo.service;

import ee.ut.tvt.hibernateDemo.model.Course;
import ee.ut.tvt.hibernateDemo.model.Lecturer;
import ee.ut.tvt.hibernateDemo.model.Speciality;
import ee.ut.tvt.hibernateDemo.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class HibernateDataService {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public HibernateDataService() {
        emf = Persistence.createEntityManagerFactory("demo");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public List<Student> getStudents() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    public List<Lecturer> getLecturers() {
        return em.createQuery("from Lecturer", Lecturer.class).getResultList();
    }

    public List<Course> getCourses() {
        return em.createQuery("from Course", Course.class).getResultList();
    }

    public List<Speciality> getSpecialities() {
        return em.createQuery("from Speciality", Speciality.class).getResultList();
    }

}
