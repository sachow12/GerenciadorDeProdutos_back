package elevar.gerenciamento.Controller;
import elevar.gerenciamento.Model.User;
import elevar.gerenciamento.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@AllArgsConstructor()
@RestController
@RequestMapping( "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/cadastro")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> read() {
        return userService.readUser();
    }
    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }
}
