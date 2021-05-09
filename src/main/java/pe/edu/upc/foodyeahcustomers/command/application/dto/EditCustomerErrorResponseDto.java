package pe.edu.upc.foodyeahcustomers.command.application.dto;

public class EditCustomerErrorResponseDto {
    private String message;
    public EditCustomerErrorResponseDto(){
        this.message="Error editando cliente uwu";
    }
    public String getMessage(){
        return message;
    }
}
