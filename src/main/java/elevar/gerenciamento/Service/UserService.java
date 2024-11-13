package elevar.gerenciamento.Service;

import elevar.gerenciamento.Model.Product;
import elevar.gerenciamento.Model.User;
import elevar.gerenciamento.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> readUser() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User login(String email, String password) {
        User user = new User();
        user = userRepository.findByEmail(email);
        if(user != null) {
            if (userRepository.findByEmail(email).getPassword().equals(password)) {
                return user;
            } else {
                throw new RuntimeException("Invalid email or password");
            }
        } else {throw new RuntimeException("dados invalidos!") ;}
    }



}
