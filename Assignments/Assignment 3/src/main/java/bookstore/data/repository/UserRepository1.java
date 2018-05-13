package bookstore.data.repository;

import bookstore.data.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository1 extends JpaRepository<User1, Integer> {
    // List<User1> findAllByUserName (String userName);
    User1 findByUserName(String userName);

    List<User1> findByUserNameAndPassword(String username, String password);

    @Modifying
    @Transactional
    @Query("update User1 u set u.password= ?1, u.role= ?2 where u.userName = ?3")
    void updateUser(String password, String role, String userName);

}
