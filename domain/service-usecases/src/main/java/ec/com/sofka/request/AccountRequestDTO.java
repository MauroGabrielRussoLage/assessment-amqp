package ec.com.sofka.request;

import ec.com.sofka.generic.util.Request;

import java.math.BigDecimal;

public class AccountRequestDTO extends Request {
    private String id;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private String status;
    private String customerId;

    public AccountRequestDTO(String aggregateId, String accountNumber, String accountType, BigDecimal balance, String customerId, String id, String status) {
        super(aggregateId);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
        this.id = id;
        this.status = status;
    }

    public AccountRequestDTO(String aggregateId) {
        super(aggregateId);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
