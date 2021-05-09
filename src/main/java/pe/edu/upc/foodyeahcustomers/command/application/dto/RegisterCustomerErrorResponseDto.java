package pe.edu.upc.foodyeahcustomers.command.application.dto;

public class RegisterCustomerErrorResponseDto {
    private String message;
    public RegisterCustomerErrorResponseDto() {
        this.message="Error al registrar cliente uwu";
    }

        public String getMessage(){
            return message;
        }

}
