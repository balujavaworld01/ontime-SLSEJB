package za.co.soulstice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.UserPhonebook;

public interface UserPhoneBookDao
		extends JpaRepository<UserPhonebook, Integer>, JpaSpecificationExecutor<UserPhonebook> {

	@Query("SELECT a FROM UserPhonebook a WHERE a.userId=:userId ORDER BY a.name ASC")
	public List<UserPhonebook> getUserPhoneBookByUserId(@Param("userId") int userId);
	
	@Query("SELECT a FROM UserPhonebook a WHERE a.userId=:userId ORDER BY a.name ASC")
	public Page<UserPhonebook> getUserPhoneBookByUserIdWithPagination(@Param("userId") int userId,Pageable page);
	
	@Query("SELECT a FROM UserPhonebook a WHERE a.mobileNumber=:mobileNumber and a.userId=:userId ORDER BY a.mobileNumber ASC")
	public Page<UserPhonebook> getUserPhoneBookByUserIdWithPaginationmob(@Param("userId") int userId,@Param("mobileNumber") String mobileNumber,Pageable page);//balu

	@Query("SELECT a FROM UserPhonebook a WHERE a.phonebookGroupName=:phonebookGroupName")
	public List<UserPhonebook> getPhoneBookDetailsByGroupName(@Param("phonebookGroupName") String phonebookGroupName);

	@Query("SELECT a FROM UserPhonebook a WHERE a.userId=:userId and a.phonebookGroupName=:phonebookGroupName")
	public List<UserPhonebook> getPhoneBookByUserIdAndGroupName(@Param("userId") int userId,
			@Param("phonebookGroupName") String phonebookGroupName);

	@Query("SELECT u FROM UserPhonebook u where u.id=:id")
	UserPhonebook getContactById(@Param("id") int contactId);

	@Query("SELECT a FROM UserPhonebook a")
	ArrayList<UserPhonebook> getAllUserPhoneBook();

	@Query(value = "select count(*) as count from comm.user_phonebook where (name =:name or mobileNumber=:mobileNumber) and groupId =:groupId", nativeQuery = true)
	Integer getDuplicateNameOrMobileNumber(@Param("mobileNumber") String mobileNumber, @Param("name") String name,
			@Param("groupId") int groupId);

	@Query(value="select count(*) as count from comm.user_phonebook where phonebookGroupName=:phonebookGroupName",nativeQuery=true)
	Integer getCountByPhonebookName(@Param("phonebookGroupName") String phonebookGroupName);

	@Modifying
	@Query("delete FROM UserPhonebook p WHERE p.userPhonebookGroup.groupId=:groupId")
	public void deletePhoneBookByGroupId(@Param("groupId") int groupId);
	
	Page<UserPhonebook> findPhoneBookByUserIdAndPhonebookGroupNameContaining(int userId,String groupName,Pageable pageable);
	

}
