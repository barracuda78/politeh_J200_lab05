package lab5;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PARAMETERS")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Parameters.findAll", query = "SELECT p FROM Parameters p")
    , @NamedQuery(name = "Parameters.findByName", query = "SELECT p FROM Parameters p WHERE p.name = :name")
    , @NamedQuery(name = "Parameters.findByRange", query = "SELECT p FROM Parameters p WHERE p.num BETWEEN :a AND :b")  
    , @NamedQuery(name = "Parameters.findBySqlRegex", query = "SELECT p FROM Parameters p WHERE p.name LIKE :a") 
    , @NamedQuery(name = "Parameters.findByNum", query = "SELECT p FROM Parameters p WHERE p.num = :num")})
public class Parameters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM")
    private int num;

    public Parameters() {
    }

    public Parameters(String name) {
        this.name = name;
    }

    public Parameters(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public boolean setNum(String numberString) {
        try{
            this.num = Integer.parseInt(numberString); //
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameters)) {
            return false;
        }
        Parameters other = (Parameters) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab5.Parameters[ name=" + name + " ]";
    }

    public String toHtmlString() {
        return "<li>lab5.Parameters[" + name + " - " + num + "] </li>";
    }
}