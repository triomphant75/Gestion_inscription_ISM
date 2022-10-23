package entities;

import core.Roles;

public class AC extends User {

    public AC(int id, String nomComplet, String login, String password) {
        super(id, nomComplet, login, password);
        role=Roles.AC;
    }


}
