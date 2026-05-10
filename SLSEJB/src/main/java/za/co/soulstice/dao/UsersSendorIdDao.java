package za.co.soulstice.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.UsersSendorId;

public interface UsersSendorIdDao extends JpaRepository<UsersSendorId, Long>, JpaSpecificationExecutor<UsersSendorId> {

	
	@Query("SELECT u FROM UsersSendorId u ORDER BY u.approvedDateAndTIme DESC")
	ArrayList<UsersSendorId> getAllSendorId();
	
	@Query("SELECT u FROM UsersSendorId u WHERE u.approved = false ORDER BY u.approvedDateAndTIme DESC")
	ArrayList<UsersSendorId> getNotApprovedSendorId();

	@Query("SELECT u FROM UsersSendorId u where u.id = :senderId")
	public UsersSendorId getSenderIdById(@Param("senderId") Long senderId);

	
	@Query("SELECT u FROM UsersSendorId u where u.userId =:userId ORDER BY u.approvedDateAndTIme DESC")
	public ArrayList<UsersSendorId> getSenderIdByUserId(@Param("userId") long userId);
	
	@Query("SELECT u FROM UsersSendorId u where u.userId =:userId and u.approved=true ORDER BY u.approvedDateAndTIme DESC")
	public ArrayList<UsersSendorId> getApprovedSenderIdByUserId(@Param("userId") long userId);
}
