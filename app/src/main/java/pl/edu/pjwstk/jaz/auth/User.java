package pl.edu.pjwstk.jaz.auth;

import java.time.LocalDate;

public class User {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String email;
    private final LocalDate birthDate;

    public User(String firstName, String lastName, String username, String password, String email, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
