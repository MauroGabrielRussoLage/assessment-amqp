package ec.com.sofka.request;

import ec.com.sofka.generic.util.Request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequestDTO extends Request {
    private String id;
    private LocalDateTime date;
    private String type;
    private BigDecimal amount;
    private String description;
    private String destinationAccountId;
    private String sourceAccountId;
    private String status;

    public TransactionRequestDTO(String aggregateId, BigDecimal amount, LocalDateTime date, String description, String destinationAccountId, String id, String sourceAccountId, String status, String type) {
        super(aggregateId);
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.destinationAccountId = destinationAccountId;
        this.id = id;
        this.sourceAccountId = sourceAccountId;
        this.status = status;
        this.type = type;
    }

    public TransactionRequestDTO(String aggregateId) {
        super(aggregateId);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
