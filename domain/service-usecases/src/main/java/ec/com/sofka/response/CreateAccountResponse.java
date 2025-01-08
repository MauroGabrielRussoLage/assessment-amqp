package ec.com.sofka.response;

import ec.com.sofka.generic.util.Request;


public class CreateAccountResponse {
    protected String message;

    public CreateAccountResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
