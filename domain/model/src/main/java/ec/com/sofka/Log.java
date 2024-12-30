package ec.com.sofka;

import java.time.LocalDateTime;

public class Log {
    private String id;
    private String message;
    private String action;
    private String level;
    private LocalDateTime timestamp;

    public Log(String action, String id, String level, String message, LocalDateTime timestamp) {
        this.action = action;
        this.id = id;
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Log() {}

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "CustomMessage{id='" + id + "', " +
                "message='" + message + "', " +
                "action='" + action + "', " +
                "level='" + level+ "', " +
                "timestamp='" + timestamp+"'}";
    }
}