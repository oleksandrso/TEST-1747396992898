package autotest.tests;

public class User {
    String country, login, password;

    public User(String country, String login, String password) {
        this.country = country;
        this.login = login;
        this.password = password;
    }

    public static void userCredential() {

    }
    public String getCountry() {
        return country;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
