package com.hoangha.jpaservlet.DTO;


import java.io.Serializable;

public class AccountDTO  implements Serializable {
    private String gmail;
    private String password;

    public AccountDTO() {};
    public AccountDTO(String gmail, String password) {
        this.gmail = gmail;
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}

