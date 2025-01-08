package ec.com.sofka.mapper;

import ec.com.sofka.account.Account;
import ec.com.sofka.aggregate.Customer;
import ec.com.sofka.data.*;
import ec.com.sofka.transaction.Transaction;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class DocumentToModelMapper {
    public static final Function<Mono<AccountDocument>, Mono<Account>> toAccount = account ->
            account.map(accountDocument -> {
                Account accountModel = new Account();
                BeanUtils.copyProperties(accountDocument, accountModel);
                return accountModel;
            });

    public static final Function<Mono<CustomerDocument>, Mono<Customer>> toCustomer = customer ->
            customer.map(customerDocument -> {
                Customer customerModel = new Customer();
                BeanUtils.copyProperties(customerDocument, customerModel);
                return customerModel;
            });

    public static final Function<Mono<TransactionDocument>, Mono<Transaction>> toTransaction = transaction ->
            transaction.map(transactionDocument -> {
                Transaction transactionModel = new Transaction();
                BeanUtils.copyProperties(transactionDocument, transactionModel);
                return transactionModel;
            });
}
