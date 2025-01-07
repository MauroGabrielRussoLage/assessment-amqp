package ec.com.sofka.aggregate.value;

import ec.com.sofka.generic.util.Identity;

public class CustomerId extends Identity {
    public CustomerId() {
        super();
    }

    private CustomerId(final String id) {
        super(id);
    }

    public static CustomerId of(final String id) {
        return new CustomerId(id);
    }
}