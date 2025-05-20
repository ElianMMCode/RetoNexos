package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import logica.Departamento;

import java.io.Serializable;
import java.util.List;

public class DepartamentoJpaController implements Serializable {
    private static final long serialVersionUID = 1L;
    private final EntityManagerFactory emf;



    public DepartamentoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("retoNexosPAPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Departamento departamento) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(departamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(Departamento departamento) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(departamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(Long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Departamento departamento;
            try {
                departamento = em.getReference(Departamento.class, id);
            } catch (Exception ex) {
                throw new Exception("The departamento with id " + id + " no longer exists.");
            }
            em.remove(departamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public Departamento findDepartamento(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Departamento.class, id);
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Departamento> findDepartamentoEntities() {
        return findDepartamentoEntities(true, -1, -1);
    }

    public List<Departamento> findDepartamentoEntities(int maxResults, int firstResult) {
        return findDepartamentoEntities(false, maxResults, firstResult);
    }

    private List<Departamento> findDepartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Departamento> q = em.createQuery("SELECT d FROM Departamento d", Departamento.class);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }

    public int getDepartamentoCount() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Long> q = em.createQuery("SELECT COUNT(d) FROM Departamento d", Long.class);
            return q.getSingleResult().intValue();
        } finally {
            if (em != null) em.close();
        }
    }
}
