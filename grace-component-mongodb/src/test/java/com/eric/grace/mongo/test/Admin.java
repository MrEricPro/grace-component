package com.eric.grace.mongo.test;

/**
 * Admin:
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:49
 */
public class Admin {

    private String _id;
    private String user;
    private String db;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "_id='" + _id + '\'' +
                ", user='" + user + '\'' +
                ", db='" + db + '\'' +
                '}';
    }
}
