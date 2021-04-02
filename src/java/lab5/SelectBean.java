
package lab5;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SelectBean {
    
    @EJB
    private ParametersFacade parametersFacade;
    
    public int count(){
        return parametersFacade.count();
    }
    
    public List<Parameters> findAll(){
        return parametersFacade.findAll();
    }
    
    public String findByRange(int a, int b){
        return parametersFacade.findByRange(a, b);
    }
}
