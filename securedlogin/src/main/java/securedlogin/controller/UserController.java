package securedlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import securedlogin.repo.UserRepo;
import securedlogin.service.ReviewService;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    public UserController() {
    }

    @PostMapping("user")
    public ResponseEntity<Integer> UserLogin(@RequestBody Map<String, String> loginData){
        String username = loginData.get("username");
        String password = loginData.get("password");
        int flag = userRepo.logincheck(username, password);
        return ResponseEntity.ok(flag);
    }

    @PostMapping("user/register")
    public int userRegist(@RequestBody Map<String, String> payload) {
        String submittedusername = payload.get("username");
        String submittedemail = payload.get("email");
        String submittedpassword = payload.get("password");
        int flag = userRepo.registcheck(submittedusername, submittedemail, submittedpassword);
        if (flag == 0) {
            flag = 1; // Başarılı kayıt durumunda 0 döndüğünde frontend için 1 yapıyoruz
        }
        return flag;
    }


    @Autowired
    private ReviewService reviewService;

    @GetMapping("reviews")
    public List<String> getReviews(@RequestParam String filmName) {
        return reviewService.getFilmReviews(filmName);
    }
}

