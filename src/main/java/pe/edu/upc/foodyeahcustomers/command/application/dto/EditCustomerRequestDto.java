package pe.edu.upc.foodyeahcustomers.command.application.dto;

public class EditCustomerRequestDto {
    private String id;
    private String customerName;
    private String customerAge;
    private String dni;
    public String getId(){
        return id;
    }
    public void setCustomerId(String id){
        this.id=id;
    }
    public String getCustomerName(){
        return customerName;

    }
    public String getCustomerAge(){
        return customerAge;
    }
    public String getDni(){
        return dni;
    }
}
