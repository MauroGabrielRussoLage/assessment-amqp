package ec.com.sofka.mapper;

import ec.com.sofka.account.Account;
import ec.com.sofka.aggregate.Customer;
import ec.com.sofka.data.*;
import ec.com.sofka.transaction.Transaction;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class ModelToDocumentMapper {
    public static final Function<Mono<Account>, Mono<AccountDocument>> toAccount = account ->
            account.map(accountModel -> {
                AccountDocument accountDocument = new AccountDocument();
                BeanUtils.copyProperties(accountModel, accountDocument);
                return accountDocument;
            });

    public static final Function<Mono<Customer>, Mono<CustomerDocument>> toCustomer = customer ->
            customer.map(customerModel -> {
                CustomerDocument customerDocument = new CustomerDocument(
                        customerModel.getId().getValue(),
                        customerModel.getFirstName().getValue(),
                        customerModel.getLastName().getValue(),
                        customerModel.getEmail().getValue(),
                        customerModel.getPhone().getValue(),
                        customerModel.getAddress().getValue(),
                        customerModel.getStatus().getValue()
                );
                return customerDocument;
            });

    public static final Function<Mono<Transaction>, Mono<TransactionDocument>> toTransaction = transaction ->
            transaction.map(transactionModel -> {
                TransactionDocument transactionDocument = new TransactionDocument();
                BeanUtils.copyProperties(transactionModel, transactionDocument);
                return transactionDocument;
            });
}
