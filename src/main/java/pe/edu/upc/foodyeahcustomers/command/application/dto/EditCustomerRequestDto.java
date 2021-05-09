package pe.edu.upc.foodyeahcustomers.command.application.dto;

public class EditCustomerRequestDto {
    private String id;
    private String customerName;
    private String customerAge;
    private String dni;
    private String customerRoles;
    private String username;
    private String password;


    public String getId(){ return id; }
    public void setCustomerId(String id){ this.id=id; }
    public String getCustomerName(){ return customerName;}
    public String getCustomerAge(){ return customerAge;}
    public String getDni(){ return dni; }
    public String getCustomerRoles(){return customerRoles;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

}
