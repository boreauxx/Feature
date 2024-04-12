package feature.exception;

import lombok.Data;

@Data
public class InvalidLoginException {

    private String username;
    private String password;

    public InvalidLoginException() {
        this.username = "Invalid Username";
        this.password = "Invalid Password";
    }
}
