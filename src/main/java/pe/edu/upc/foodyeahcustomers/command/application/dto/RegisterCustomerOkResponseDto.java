package pe.edu.upc.foodyeahcustomers.command.application.dto;

    public class RegisterCustomerOkResponseDto {
        private String id;
        public RegisterCustomerOkResponseDto(String id){
            this.id=id;
        }
        public String getId(){
            return id;
        }
}
