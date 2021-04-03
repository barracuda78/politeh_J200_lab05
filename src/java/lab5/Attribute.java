
package lab5;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Singleton;


@Singleton
public class Attribute {

    @EJB
    private SelectBean selectBean;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //ОН ДОЛЖЕН ЛАЗИТЬ В БАЗУ!!!

    private List<Parameters> list = null;

    public void addToList(Parameters parameter) {
        selectBean.edit(parameter);
    }

    public List<Parameters> getList() {
        return list = selectBean.findAll();
    }
    
    
}
