package za.co.soulstice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.UserPhoneBookGroup;


public interface UserPhoneBookGroupDao
		extends JpaRepository<UserPhoneBookGroup, Integer>, JpaSpecificationExecutor<UserPhoneBookGroup> {

	
	@Query("SELECT a FROM UserPhoneBookGroup a WHERE a.groupName=:groupName")
	public UserPhoneBookGroup getUserPhoneBookGroupByGroupName(@Param("groupName") String groupName);

	
	@Query("SELECT a FROM UserPhoneBookGroup a WHERE a.createdUserId=:createdUserId")
	List<UserPhoneBookGroup> getUserGroupByUserid(@Param("createdUserId") int createdUserId);
	
	
	
	
}
