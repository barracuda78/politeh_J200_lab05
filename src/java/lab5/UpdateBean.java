package lab5;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class UpdateBean {

    @EJB
    private ParametersFacade parametersFacade;
    
    

    public void addParameter(Parameters parameter) {
        parametersFacade.persist(parameter);   //---------------> ИВ делал так
        parametersFacade.create(parameter);
        
    }
    
    
   
}
