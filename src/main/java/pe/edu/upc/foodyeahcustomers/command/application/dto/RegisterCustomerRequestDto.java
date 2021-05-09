package pe.edu.upc.foodyeahcustomers.command.application.dto;

public class RegisterCustomerRequestDto {
    private String id;
    private String customerName;
    private String customerAge;
    public String dni;
    public String getId(){
        return id;
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
