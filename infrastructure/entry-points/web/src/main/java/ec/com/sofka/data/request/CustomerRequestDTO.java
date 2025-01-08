package ec.com.sofka.data.request;

import ec.com.sofka.generic.util.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
public class CustomerRequestDTO extends Request {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private List<AccountRequestDTO> accounts;

    protected CustomerRequestDTO(String aggregateId) {
        super(aggregateId);
    }


}
