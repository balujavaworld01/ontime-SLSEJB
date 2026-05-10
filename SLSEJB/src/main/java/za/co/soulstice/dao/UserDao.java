package za.co.soulstice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.User;


public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	
	@Query("SELECT u FROM User u WHERE u.userId=:userId")
	User findUserById(@Param("userId") long userId);

	
	@Query("SELECT u FROM User u WHERE u.token=:token")
	User findUserByToken(@Param("token") String token);

	
	@Query("SELECT u FROM User u WHERE u.userName=:userName AND u.password=:password")
	User findUserByDetails(@Param("userName") String userName, @Param("password") String password);

	
	@Query("SELECT a FROM User a WHERE a.user=:user ORDER BY a.userCreatedDate DESC")
	public ArrayList<User> getAllUserByAdmin(@Param("user") User user);

	
	@Query("SELECT u FROM User u ORDER BY u.userCreatedDate DESC")
	List<User> findAll();

	
	@Query("SELECT u FROM User u WHERE u.emailAddress=:emailAddress AND u.phoneNumber=:phoneNumber")
	User findUserByMailAndNumber(@Param("emailAddress") String emailAddress, @Param("phoneNumber") String phoneNumber);
	
	Page<User> findByUserNameContaining(String userName,Pageable pageable);
}
