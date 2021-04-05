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
    
    @EJB
    private Attribute attribute;
    
    public int addParameter(String name, String number) {
            if(name == null || name.isEmpty()){
                //имя параметра не указано
                 return 0;
            }
            if(number == null || number.isEmpty()){
                //значение number не указано
                 return 1;
            }
            
            name = name.trim();
            
            if( name.isEmpty()){
                //имя должно содержать не менее одного непробельного символа.
                 return 2;
            }
            else if(name.length() > 255){
                //слишком длинное имя
                return 3;
            }
            
            int num;
            try{
                num = Integer.parseInt(number);
            }catch(NumberFormatException e){
                //некорректное число
                return 4;
            }
            
            Parameters parameter = new Parameters(name, num);
            //тут запилить логику - если такой есть - обновить ему значение.
            Parameters p = parametersFacade.find(parameter.getName());
            if(p == null){
                System.out.println("-----------------------p == null");
                parametersFacade.persist(parameter);   //---------------> ИВ делал так
                parametersFacade.create(parameter);
                attribute.addToList(parameter);
                return 5;
            }else{
                //если нашёл его - обновить ему значение..
                System.out.println("-----------------------p != null");
                parametersFacade.edit(parameter);
                return 6;
            }
    }

    public int addParameter(Parameters parameter) {
        if (null == parameter)
            return 0;
        //удалить пробельные символы из имени параметра:
        parameter.setName(parameter.getName().trim());
        
        String s = parameter.getName();
        if(s.isEmpty())
            return 3;
        
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
    
    //удаляет одну запись с параметром по заданному имени:

    public boolean deleteOne(String parameter) {
        if(parameter == null || parameter.isEmpty()){
            System.out.println("UpdateBean метод deleteOne(): parameter == null || parameter.isEmpty()");
            return false;
        }
        
        List<Parameters> list = selectBean.findAll();
        boolean deleted = false;
        for(Parameters p : list){
            if(p.getName().equals(parameter)){
                //удаляем его
                parametersFacade.remove(p);
                System.out.println("UpdateBean метод deleteOne(): параметр успешно удален");
                deleted = true;
            }
        }
        return deleted;
    }
    
        //удаляет записи соответствующие регулярке:

    public boolean deleteRegex(String regex) {
        
        if(regex == null || regex.isEmpty()){
            System.out.println("UpdateBean метод deleteRegex(): regex == null || regex.isEmpty()");
            return false;
        }
        
        boolean deleted = false;
        List<Parameters> list = selectBean.findAll();
        for(Parameters p : list){
            if(p.getName().matches(regex)){
                //удаляем его
                parametersFacade.remove(p);
                System.out.println("UpdateBean метод deleteRegex(): параметр успешно удален");
                deleted = true;
            }
        }
        return deleted;
    }

}
