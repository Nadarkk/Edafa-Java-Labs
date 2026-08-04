public abstract class User {
    private final String Username;
    private final  String Email;
    private String Password;

    User(String Username, String Email, String Password) {
        this.Username = Username;
        this.Email = Email;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public abstract void viewRole();


}


