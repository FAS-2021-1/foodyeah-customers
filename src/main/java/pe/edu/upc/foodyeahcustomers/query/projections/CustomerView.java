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
    @Column
    private Instant createdAt;
    @Column(nullable=true)
    private Instant updatedAt;
    @Column
    private String customerRoles;
    @Column
    private String username;
    @Column
    private String password;
    public CustomerView(){

    }
    public CustomerView(String id,String customerName,String customerAge,String status,String customerRoles,String username,String password,String dni,Instant createdAt){
        this.id=id;
        this.customerAge=customerAge;
        this.customerName=customerName;
        this.dni=dni;
        this.status=status;
        this.createdAt=createdAt;
        this.customerRoles=customerRoles;
        this.username=username;
        this.password=password;
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
    public Instant getCreatedAt(){return createdAt;}
    public void setUpdatedAt(Instant updatedAt){this.updatedAt=updatedAt;}
    public String getCustomerRoles(){
        return customerRoles;
    }
    public void setCustomerRoles(String customerRoles){
        this.customerRoles=customerRoles;

    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setCreatedAt(Instant createdAt){
        this.createdAt=createdAt;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

}
