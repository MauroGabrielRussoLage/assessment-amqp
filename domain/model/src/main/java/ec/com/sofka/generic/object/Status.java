package ec.com.sofka.generic.object;

import ec.com.sofka.generic.interfaces.ValueObject;

public class Status implements ValueObject<String> {
    private final String value;

    private Status(final String value) {
        this.value = validate(value);
    }

    public static Status of(final String value) {
        return new Status(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private String validate(final String value){
        //TODO Validaciones
        if(value == null){
            throw new IllegalArgumentException("The status can't be null");
        }
        if(value.isBlank()){
            throw new IllegalArgumentException("The status can't be empty");
        }
        if(value.length() < 3){
            throw new IllegalArgumentException("The status must have at least 3 characters");
        }
        return value;
    }
}
