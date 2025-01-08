package ec.com.sofka.aggregate.events;

import ec.com.sofka.account.value.AccountNumber;
import ec.com.sofka.account.value.AccountType;
import ec.com.sofka.account.value.Balance;
import ec.com.sofka.aggregate.value.CustomerId;
import ec.com.sofka.generic.domain.DomainEvent;
import ec.com.sofka.generic.object.Status;

public class AccountCreated extends DomainEvent {
    private final AccountNumber accountNumber;
    private final AccountType accountType;
    private final Balance balance;
    private final Status status;;

    public AccountCreated(AccountNumber accountNumber, AccountType accountType, Balance balance, Status status) {
        super(EventsEnum.ACCOUNT_CREATED.name());
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Balance getBalance() {
        return balance;
    }

    public Status getStatus() {
        return status;
    }

}
