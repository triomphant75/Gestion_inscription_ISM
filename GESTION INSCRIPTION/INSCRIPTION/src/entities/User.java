package entities;

import core.Roles;

public class User {

    protected int id;
    protected String nomComplet;
    protected String login;
    protected String password;
    protected Roles role;


    public User(int id, String nomComplet) {
        this.id = id;
        this.nomComplet = nomComplet;
    }



    public User(String nomComplet) {
        this.nomComplet = nomComplet;
    }



    public User(int id, String nomComplet, String login, String password) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.login = login;
        this.password = password;
    }
       
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", nomComplet=" + nomComplet + ", login=" + login + ", password=" + password
                + ", role=" + role ;
    }

}

   

