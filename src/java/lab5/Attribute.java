
package lab5;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;


@Singleton
public class Attribute {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //ОН ДОЛЖЕН ЛАЗИТЬ В БАЗУ!!!
    
    private List<Parameters> list = new ArrayList<>();

    public void addToList(Parameters parameter) {
        list.add(parameter);
    }

    public List<Parameters> getList() {
        return list;
    }
    
    
}
