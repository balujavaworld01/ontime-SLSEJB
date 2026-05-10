package za.co.soulstice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.User;
import za.co.soulstice.model.UserAccount;

// TODO: Auto-generated Javadoc

public interface UserAccountDao extends JpaRepository<UserAccount, Long>, JpaSpecificationExecutor<UserAccount> {

	
	@Query("SELECT u FROM UserAccount u WHERE u.id=:id")
	UserAccount findUserAccountById(@Param("id") long id);

	
	@Query("SELECT u FROM UserAccount u WHERE u.user=:user")
	UserAccount findUserAccountByUserId(@Param("user") User user);

	
	@Query("SELECT u FROM UserAccount u")
	ArrayList<UserAccount> getAllgetWay();

	
	@Query("SELECT u FROM UserAccount u WHERE u.user.userId=:userId")
	UserAccount getAccountBasedOnUserId(@Param("userId") long userId);

}
