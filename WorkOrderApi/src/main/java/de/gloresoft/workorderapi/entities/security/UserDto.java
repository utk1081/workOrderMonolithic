package de.gloresoft.workorderapi.entities.security;


public class UserDto {

    private String username;
    private String password;
    private String dateOfBirth;
    private String role;

    public UserDto() {
    }

    public UserDto(String username, String password, String dateOfBirth, String role) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
