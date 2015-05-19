/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author pafuaai
 */
public class quizJpaController implements Serializable {

    public quizJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(quiz quiz) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(quiz);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(quiz quiz) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            quiz = em.merge(quiz);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = quiz.getId();
                if (findquiz(id) == null) {
                    throw new NonexistentEntityException("The quiz with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            quiz quiz;
            try {
                quiz = em.getReference(quiz.class, id);
                quiz.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The quiz with id " + id + " no longer exists.", enfe);
            }
            em.remove(quiz);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<quiz> findquizEntities() {
        return findquizEntities(true, -1, -1);
    }

    public List<quiz> findquizEntities(int maxResults, int firstResult) {
        return findquizEntities(false, maxResults, firstResult);
    }

    private List<quiz> findquizEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(quiz.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public quiz findquiz(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(quiz.class, id);
        } finally {
            em.close();
        }
    }

    public int getquizCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<quiz> rt = cq.from(quiz.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public quiz getRandomQuiz(){
        quiz q=null;
        Random r = new Random();
        int rnd;
        rnd =r.nextInt(getquizCount())+1;

        long id = rnd;
        q = findquiz(id);
        return q;
    }
}
