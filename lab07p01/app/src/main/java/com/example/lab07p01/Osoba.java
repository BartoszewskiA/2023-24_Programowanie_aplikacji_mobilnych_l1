package com.example.lab07p01;

public class Osoba {
    private String login;
    private String pass;

   public Osoba(String login, String pass)
    {
        this.login = login;
        this.pass = pass;
    }

    public boolean sprawdz(String login, String pass)
    {
        if(this.login.equals(login) && this.pass.equals(pass))
            return true;
        else
            return false;
    }

}
