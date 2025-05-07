package testcases;

public class JsonData {
    private String password;
    private String error;

    public JsonData() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "password='" + password + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
