package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import logica.Empleado;

import java.io.Serializable;
import java.util.List;

public class EmpleadoJpaController implements Serializable {
    private static final long serialVersionUID = 1L;
    private final EntityManagerFactory emf;

    public EmpleadoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("retoNexosPAPU");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    public void edit(Empleado empleado) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public void destroy(String documentoNumero) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Empleado empleado = em.find(Empleado.class, documentoNumero);
            if (empleado == null) {
                throw new Exception("El empleado con numero de documento " + documentoNumero + " no existe.");
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally {
            if (em != null) em.close();
        }
    }

    public Empleado findEmpleado(String documentoNumero) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, documentoNumero);
        } finally {
            if (em != null) em.close();
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Empleado> q = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
            return q.getResultList();
        } finally {
            if (em != null) em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Long> q = em.createQuery("SELECT COUNT(e) FROM Empleado e", Long.class);
            return q.getSingleResult().intValue();
        } finally {
            if (em != null) em.close();
        }
    }
}
