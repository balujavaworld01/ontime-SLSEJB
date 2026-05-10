package za.co.soulstice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.UserTemplate;



public interface UserTemplateDao extends JpaRepository<UserTemplate, Integer>, JpaSpecificationExecutor<UserTemplate> {

	
	@Query("SELECT a FROM UserTemplate a ORDER BY a.approvedDateAndTime DESC")
	ArrayList<UserTemplate> getAllTemplate();

	
	@Query("SELECT u FROM UserTemplate u where u.id =:templateId")
	public UserTemplate getTemplateIdById(@Param("templateId") int templateId);

	
	@Query("SELECT u FROM UserTemplate u where u.userId = :userId ORDER BY u.approvedDateAndTime DESC")
	List<UserTemplate> getTemplateIdByUserId(@Param("userId") long userId);

	
	@Query("SELECT u FROM UserTemplate u where u.userId =:userId AND u.approved=true ORDER BY u.approvedDateAndTime DESC")
	List<UserTemplate> getApprovedTemplateIdByUserId(@Param("userId") long userId);
}
