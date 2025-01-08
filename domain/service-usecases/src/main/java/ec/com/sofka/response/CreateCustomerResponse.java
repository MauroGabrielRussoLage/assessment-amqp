package ec.com.sofka.response;

import ec.com.sofka.generic.util.Request;


public class CreateCustomerResponse {
    protected String message;

    public CreateCustomerResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
