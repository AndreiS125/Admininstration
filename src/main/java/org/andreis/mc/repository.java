package org.andreis.mc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class repository {

    private String url;
    public repository() throws Exception {

        url = "jdbc:sqlite:plugins/players.db";
        Class.forName("org.sqlite.JDBC").newInstance();

        Connection c = getConnection();
        Statement s = c.createStatement();

        s.executeUpdate("CREATE TABLE IF NOT EXISTS users ('nickname' TEXT, 'rank' TEXT)");

        s.close();
        c.close();

    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url);
    }

    public void add(String nickname, String rank) {
        try {
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            s.executeUpdate("INSERT INTO users VALUES ('" + nickname +", "+rank+ "')");
            s.close();
            c.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getRank(String nickname) {
        try {
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery("Select * from users");

            s.close();
            c.close();
            return resultSet.getString("rank");
        }
        catch(Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void remove(String nickname) {
        try {
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            s.executeUpdate("DELETE FROM users WHERE nickname = '" + nickname + "'");
            s.close();
            c.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}