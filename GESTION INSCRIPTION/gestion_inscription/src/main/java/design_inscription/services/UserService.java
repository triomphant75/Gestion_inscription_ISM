package design_inscription.services;

import design_inscription.entities.User;
import design_inscription.repositories.IUserRepository;

public class UserService implements IUserService {
    
    IUserRepository userRepository;
   
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User Connexion_user_admin(String login, String password) {
        return userRepository.findUserByLoginAndPassword(login, password);
    }
  
    
}
