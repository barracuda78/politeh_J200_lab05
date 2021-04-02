package lab5;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UpdateBean {

    @EJB
    private ParametersFacade parametersFacade;

    public int addParameter(Parameters parameter) {
        //тут запилить логику - если такой есть - обновить ему значение.
        Parameters p = parametersFacade.find(parameter.getName());
        if(p == null){
            System.out.println("-----------------------p == null");
            parametersFacade.persist(parameter);   //---------------> ИВ делал так
            parametersFacade.create(parameter);
            return 1;
        }else{
            //если нашёл его - обновить ему параметр.
            System.out.println("-----------------------p != null");
            parametersFacade.edit(parameter);
            return 2;
        }
    }
}
