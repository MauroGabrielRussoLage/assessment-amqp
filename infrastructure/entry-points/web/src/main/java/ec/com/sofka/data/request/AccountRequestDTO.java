package ec.com.sofka.data.request;

import ec.com.sofka.data.response.CardResponseDTO;
import ec.com.sofka.data.response.TransactionResponseDTO;
import ec.com.sofka.request.CardRequestDTO;
import ec.com.sofka.request.TransactionRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDTO {
    private int id;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private List<CardRequestDTO> cards;
    private List<TransactionRequestDTO> transactions;
}
