package za.co.soulstice.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.SupportStatus;


public interface SupportStatusDao
		extends JpaRepository<SupportStatus, Integer>, JpaSpecificationExecutor<SupportStatus> {

	
	@Query("SELECT a FROM SupportStatus a WHERE a.id=:id")
	SupportStatus getRequestById(@Param("id") int id);

	
	@Query("SELECT a FROM SupportStatus a")
	ArrayList<SupportStatus> getAllStatus();

	
	@Query("SELECT a FROM SupportStatus a WHERE a.userId=:userId")
	public ArrayList<SupportStatus> getAllStatusByUser(@Param("userId") int userId);
}
