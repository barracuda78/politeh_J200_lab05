package lab5;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UpdateBean {

    @EJB
    private SelectBean selectBean;

    @EJB
    private ParametersFacade parametersFacade;
    
    

    public int addParameter(Parameters parameter) {
        if (parameter == null)
            return 0;
        //удалить пробельные символы из имени параметра:
        parameter.setName(parameter.getName().trim());
        
        //тут запилить логику - если такой есть - обновить ему значение.
        Parameters p = parametersFacade.find(parameter.getName());
        if(p == null){
            System.out.println("-----------------------p == null");
            parametersFacade.persist(parameter);   //---------------> ИВ делал так
            parametersFacade.create(parameter);
            return 1;
        }else{
            //если нашёл его - обновить ему значение..
            System.out.println("-----------------------p != null");
            parametersFacade.edit(parameter);
            return 2;
        }
    }

    //удаляет все записи из таблицы с параметрами:
    public int deleteAll() {
        List<Parameters> list = selectBean.findAll();
        for(Parameters p : list){
            parametersFacade.remove(p);             //-------------------> возможно тут нужно через итератор!
        }
        
        return 0;
    }
    
    
}
