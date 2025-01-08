package ec.com.sofka.mapper;

import ec.com.sofka.account.Account;
import ec.com.sofka.aggregate.Customer;
import ec.com.sofka.data.request.*;
import ec.com.sofka.transaction.Transaction;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class DTORequestMapper {

    public static final Function<Mono<Account>, Mono<AccountRequestDTO>> toAccountRequestDTO = account ->
            account.map(accountEntity -> {
                AccountRequestDTO accountDTO = new AccountRequestDTO();
                BeanUtils.copyProperties(accountEntity, accountDTO);
                return accountDTO;
            });

    public static final Function<Mono<Customer>, Mono<CustomerRequestDTO>> toCustomerRequestDTO = customer ->
            customer.map(customerEntity -> {
                CustomerRequestDTO customerDTO = new CustomerRequestDTO();
                BeanUtils.copyProperties(customerEntity, customerDTO);
                return customerDTO;
            });

    public static final Function<Mono<Transaction>, Mono<TransactionRequestDTO>> toTransactionRequestDTO = transaction ->
            transaction.map(transactionEntity -> {
                TransactionRequestDTO transactionDTO = new TransactionRequestDTO();
                BeanUtils.copyProperties(transactionEntity, transactionDTO);
                return transactionDTO;
            });

    public static final Function<Mono<AccountRequestDTO>, Mono<Account>> toAccount = accountDTO ->
            accountDTO.map(DTO -> {
                Account account = new Account();
                BeanUtils.copyProperties(DTO, account);
                return account;
            });

    public static final Function<Mono<CustomerRequestDTO>, Mono<Customer>> toCustomer = customerDTO ->
            customerDTO.map(DTO -> {
                Customer customer = new Customer();
                BeanUtils.copyProperties(DTO, customer);
                return customer;
            });

    public static final Function<Mono<TransactionRequestDTO>, Mono<Transaction>> toTransaction = transactionDTO ->
            transactionDTO.map(DTO -> {
                Transaction transaction = new Transaction();
                BeanUtils.copyProperties(DTO, transaction);
                return transaction;
            });
}