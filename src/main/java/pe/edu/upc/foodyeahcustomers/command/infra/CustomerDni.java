package pe.edu.upc.foodyeahcustomers.command.infra;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CustomerDni {
    @Id
    @Column
    public String dni;
    public String id;
    public CustomerDni(){

    }
    public CustomerDni(String dni, String id){
        this.dni=dni;
        this.id=id;

    }
    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
}
