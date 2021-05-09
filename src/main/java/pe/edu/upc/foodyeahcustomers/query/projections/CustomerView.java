package pe.edu.upc.foodyeahcustomers.query.projections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
@Entity
public class CustomerView {
    @Id
    @Column
    private String id;
    @Column
    private String customerName;
    @Column
    private String customerAge;
    @Column
    private String dni;
    @Column
    private String status;
    private Instant createdAt;
    @Column(nullable=true)
    private Instant updatedAt;
    public CustomerView(){

    }
    public CustomerView(String id,String customerName,String customerAge,String dni,String status,Instant createdAt){
        this.id=id;
        this.customerAge=customerAge;
        this.customerName=customerName;
        this.dni=dni;
        this.status=status;
        this.createdAt=createdAt;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;

    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName=customerName;

    }
    public String getCustomerAge(){
        return customerAge;
    }
    public void setCustomerAge(String customerName){
        this.customerAge=customerAge;
    }
    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni=dni;

    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public Instant getUpdatedAt(){
        return updatedAt;
    }

}
