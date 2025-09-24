package com.hoangha.jpaservlet.DAO;



import com.hoangha.jpaservlet.DTO.AccountDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=chieuT3;encrypt=true;trustServerCertificate=true";
    //    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=chieuT3";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "Abc123@@";

    public List<AccountDTO> getAllUsers() {

        List<AccountDTO> usersList = new ArrayList<AccountDTO>();
        // Load SQL Server JDBC Driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Không tìm thấy driver JDBC SQL Server!");
            return usersList;
        }

        String sql = "SELECT * FROM dbo.account"; // thêm dbo. để chắc chắn schema

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setGmail(rs.getString("gmail"));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // in ra lỗi chi tiết
            System.out.println("Lỗi ở AccountDAO: " + e.getMessage());
        }

        return usersList;
    }

    public AccountDTO checkLogin(String gmail, String password) {
        String sql = "SELECT * FROM dbo.account WHERE gmail=? AND password=?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Không tìm thấy driver JDBC SQL Server!");
            return null;
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, gmail);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AccountDTO user = new AccountDTO();// nếu có cột id
                user.setGmail(rs.getString("gmail"));  // thay name thành gmail
                user.setPassword(rs.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // nếu không tìm thấy
    }

    public boolean addUser(AccountDTO user) {
        String sql = "INSERT INTO dbo.account(gmail, password) VALUES (?, ?)";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getGmail());
            ps.setString(2, user.getPassword());

            int row = ps.executeUpdate();
            return row > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkEmailExists(String email) {
        // Load SQL Server JDBC Driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Không tìm thấy driver JDBC SQL Server!");
            return false;
        }
        String sql = "SELECT COUNT(*) FROM dbo.account WHERE gmail = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getInt(1) > 0; // nếu COUNT > 0 thì email tồn tại
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi checkEmailExists: " + e.getMessage());
        }
        return false;
    }

    public boolean updatePassword(String gmail, String newPass) {
        String sql = "UPDATE dbo.account SET password=? WHERE gmail=?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, newPass);
                ps.setString(2, gmail);

                int row = ps.executeUpdate();
                return row > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi updatePassword: " + e.getMessage());
        }
        return false;
    }
}

