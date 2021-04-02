package lab5;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ParametersFacade extends AbstractFacade<Parameters> {

    @PersistenceContext(unitName = "j200Lab5PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametersFacade() {
        super(Parameters.class);
    }
    
    public void persist(Parameters p){
        em.persist(p);
    }

    public String findByRange(int a, int b) {
        TypedQuery<Parameters> query = em.createNamedQuery("Parameters.findByRange", Parameters.class);
        
        List<Parameters> lp = query.setParameter("a", a).setParameter("b", b).getResultList();
        
        StringBuilder sb = new StringBuilder("<ul>");
        for(Parameters p : lp){
            sb.append(p.toHtmlString());
        }
        sb.append("</ul>");
        
        return sb.toString();
    }
}
