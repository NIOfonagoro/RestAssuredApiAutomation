package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class User {

    public static final String LOGIN = "login";
    public static final String ID = "id";

    private String login;
    private String id;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String website;
    private String status;

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getStatus() {
        return status;
    }

    @JsonProperty("result")
    public void unmarshallNestedJson(Map<String, Object> resources){
        Map<String, String> core = (Map<String, String>) resources.get("core");
        id = core.get("id");

        Map<String, String> search = (Map<String, String>) resources.get("search");
        gender = String.valueOf(search.get("limit"));
    }
}