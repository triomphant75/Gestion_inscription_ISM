package entities;

import core.Roles;

public class RP extends User {



    public RP(int id, String nomComplet, String login, String password) {
        super(id, nomComplet, login, password);
        role=Roles.RP;
    }


    
}
