package design_inscription.services;

import design_inscription.entities.User;

public interface IUserService {
    public User Connexion_user_admin(String login, String password);

    
}
