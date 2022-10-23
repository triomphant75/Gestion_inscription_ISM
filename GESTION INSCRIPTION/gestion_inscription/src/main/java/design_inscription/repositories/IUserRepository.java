package design_inscription.repositories;

import design_inscription.entities.User;

public interface IUserRepository {
    
    public User findUserByLoginAndPassword(String login, String password);
}
