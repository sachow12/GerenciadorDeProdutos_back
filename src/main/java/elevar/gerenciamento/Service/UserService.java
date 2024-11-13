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
}
