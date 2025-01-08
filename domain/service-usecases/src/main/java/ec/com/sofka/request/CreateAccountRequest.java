package ec.com.sofka.request;

import ec.com.sofka.generic.util.Request;

import java.math.BigDecimal;

public class CreateAccountRequest extends Request {
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private String status;

    protected CreateAccountRequest(String aggregateId) {
        super(aggregateId);
    }

    public CreateAccountRequest(String aggregateId, String accountNumber, String accountType, BigDecimal balance, String status) {
        super(aggregateId);
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    // Builder
    public static Builder builder(String aggregateId) {
        return new Builder(aggregateId);
    }

    public static class Builder {
        private final String aggregateId;
        private String accountNumber;
        private String accountType;
        private BigDecimal balance;
        private String status;

        private Builder(String aggregateId) {
            this.aggregateId = aggregateId;
        }

        public Builder withAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder withAccountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder withBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public CreateAccountRequest build() {
            return new CreateAccountRequest(aggregateId, accountNumber, accountType, balance, status);
        }
    }
}
