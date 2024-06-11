package securedlogin.repo;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {

    public int logincheck(String username, String password);

    public int registcheck(String username, String email, String password);
}
