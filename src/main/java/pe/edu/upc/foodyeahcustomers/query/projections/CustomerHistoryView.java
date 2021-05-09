package pe.edu.upc.foodyeahcustomers.query.projections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
@Entity
public class CustomerHistoryView {
    @Id
    @GeneratedValue
    private long customerHistoryId;
    @Column
    private String id;
    @Column
    private String customerName;
    @Column
    private String customerAge;
    @Column
    private String status;
    @Column
    private Instant createdAt;
    @Column
    private String customerRoles;
    @Column
    private String dni;
    @Column
    private String username;
    @Column
    private String password;
    public CustomerHistoryView(){

    }
    public CustomerHistoryView(String id,String customerName,String customerAge,String status,String customerRoles,String username,String password,String dni,Instant createdAt){
        this.id=id;
        this.customerName=customerName;
        this.customerAge=customerAge;
        this.status=status;
        this.createdAt=createdAt;
        this.customerRoles=customerRoles;
        this.username=username;
        this.password=password;
        this.dni=dni;

    }

    public CustomerHistoryView(CustomerHistoryView customerHistoryview){
        this.id=customerHistoryview.getId();
        this.customerName=customerHistoryview.getUsername();
        this.customerAge=customerHistoryview.getCustomerAge();
        this.status=customerHistoryview.getStatus();
        this.createdAt=customerHistoryview.getCreatedAt();
        this.customerRoles=customerHistoryview.getCustomerRoles();
        this.username=customerHistoryview.getUsername();
        this.password=customerHistoryview.getPassword();
        this.dni=dni;

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

    public void setCustomerAge(String customerAge){
        this.customerAge=customerAge;
    }

    public Instant getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt){
        this.createdAt=createdAt;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

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

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni=dni;
    }


}
