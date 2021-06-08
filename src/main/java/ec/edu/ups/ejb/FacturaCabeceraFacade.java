/**
 * 
 */
package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.FacturaCabecera;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera> {
	@PersistenceContext(unitName = "Practica_3_EJB_JSF_JPA")
    private EntityManager em;

    public FacturaCabeceraFacade() {
        super(FacturaCabecera.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em; 
    }
    
    public List<FacturaCabecera> findByStatuPendiente() {
        String jpql = "FROM FacturaCabecera fc WHERE fc.estado = 'pendiente' ORDER BY fc.codigo DESC"; 
        return (List<FacturaCabecera>) em.createQuery(jpql).getResultList();
    }
    
    public List<FacturaCabecera> findByStatuNotPendiente() {
        String jpql = "FROM FacturaCabecera fc WHERE fc.estado <> 'pendiente' ORDER BY fc.codigo DESC";
        return (List<FacturaCabecera>) em.createQuery(jpql).getResultList();
    }

}
