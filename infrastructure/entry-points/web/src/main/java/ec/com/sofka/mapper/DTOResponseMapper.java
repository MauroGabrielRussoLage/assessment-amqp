package ec.com.sofka.mapper;

import ec.com.sofka.account.Account;
import ec.com.sofka.aggregate.Customer;
import ec.com.sofka.data.response.*;
import ec.com.sofka.transaction.Transaction;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class DTOResponseMapper {

    public static final Function<Mono<Account>, Mono<AccountResponseDTO>> toAccountResponseDTO = account ->
            account.map(accountEntity -> {
                AccountResponseDTO accountDTO = new AccountResponseDTO();
                BeanUtils.copyProperties(accountEntity, accountDTO);
                return accountDTO;
            });

    public static final Function<Mono<Customer>, Mono<CustomerResponseDTO>> toCustomerResponseDTO = customer ->
            customer.map(customerEntity -> {
                CustomerResponseDTO customerDTO = new CustomerResponseDTO();
                BeanUtils.copyProperties(customerEntity, customerDTO);
                return customerDTO;
            });

    public static final Function<Mono<Transaction>, Mono<TransactionResponseDTO>> toTransactionResponseDTO = transaction ->
            transaction.map(transactionEntity -> {
                TransactionResponseDTO transactionDTO = new TransactionResponseDTO();
                BeanUtils.copyProperties(transactionEntity, transaction);
                return transactionDTO;
            });

    public static final Function<Mono<AccountResponseDTO>, Mono<Account>> toAccount = accountDTO ->
            accountDTO.map(DTO -> {
                Account account = new Account();
                BeanUtils.copyProperties(DTO, account);
                return account;
            });

    public static final Function<Mono<CustomerResponseDTO>, Mono<Customer>> toCustomer = customerDTO ->
            customerDTO.map(DTO -> {
                Customer customer = new Customer();
                BeanUtils.copyProperties(DTO, customer);
                return customer;
            });

    public static final Function<Mono<TransactionResponseDTO>, Mono<Transaction>> toTransaction = transactionDTO ->
            transactionDTO.map(DTO -> {
                Transaction transaction = new Transaction();
                BeanUtils.copyProperties(DTO, transaction);
                return transaction;
            });
}