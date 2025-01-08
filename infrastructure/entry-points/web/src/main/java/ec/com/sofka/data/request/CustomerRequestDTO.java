package ec.com.sofka.data.request;

import ec.com.sofka.generic.util.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequestDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private List<AccountRequestDTO> accounts;
}
