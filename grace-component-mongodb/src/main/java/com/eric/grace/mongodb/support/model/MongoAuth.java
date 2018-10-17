package com.eric.grace.mongodb.support.model;

/**
 * MongoAuth:
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:17
 */
public class MongoAuth {
    private String username;
    private String password;
    private String authDatabase;

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

    public String getAuthDatabase() {
        return authDatabase;
    }

    public void setAuthDatabase(String authDatabase) {
        this.authDatabase = authDatabase;
    }
}
