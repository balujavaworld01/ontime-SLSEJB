package za.co.soulstice.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.UserMessage;


public interface UserMessageDao extends JpaRepository<UserMessage, Integer>, JpaSpecificationExecutor<UserMessage> { 
	

	@Query("SELECT n FROM UserMessage n WHERE n.userId =:userId")
	ArrayList<UserMessage> getMessagesByUserId(@Param("userId") long userId);

}
