package com.finalproject.dao;

import com.finalproject.model.Projects;
import com.finalproject.util.FinalUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FinalDAO {
    String databaseURL = "jdbc:mysql://localhost:3306/myprojects";
    String user = "root";
    String password = "password";

//
//    Save Projects
//    @param projects

    public static void saveProjects(Projects projects) {
        Transaction transaction = null;
        try (Session session = FinalUtils.getProjectSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the project object
            session.save(projects);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

//
//      Update Projects
//      @param projects

    public static void updateProjects(Projects projects) {
        Transaction transaction = null;
        try (Session session = FinalUtils.getProjectSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the project object
            session.update(projects);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

//
//      Delete Projects
//      @param id

    public static void deleteProjects(int id) {

        Transaction transaction = null;
        try (Session session = FinalUtils.getProjectSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a projects object
            Projects projects = session.get(Projects.class, id);
            if (projects != null) {
                session.delete(projects);
                System.out.println("project is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    //
//      Get Projects By ID
//      @param id
//      @return
//
    public static Projects getProjects(int id) {

        Transaction transaction = null;
        Projects Projects = null;
        try (Session session = FinalUtils.getProjectSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get a projects object
            Projects = session.get(Projects.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return Projects;
    }

    //
//      Get all Projects
//      @return
//
    @SuppressWarnings("unchecked")
    public List<Projects> getAllProjects() {

        Transaction transaction = null;
        List<Projects> listOfProjects = null;
        try (Session session = FinalUtils.getProjectSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get a projects object

            listOfProjects = session.createQuery("from Projects").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfProjects;
    }
}