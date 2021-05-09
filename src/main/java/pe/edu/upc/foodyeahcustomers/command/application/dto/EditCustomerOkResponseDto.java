package pe.edu.upc.foodyeahcustomers.command.application.dto;

public class EditCustomerOkResponseDto {
    private String id;
    public EditCustomerOkResponseDto(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
}
