package za.co.soulstice.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import za.co.soulstice.model.HelpDesk;



public interface HelpDeskDao extends JpaRepository<HelpDesk, Long>, JpaSpecificationExecutor<HelpDesk> {

	
	@Query("SELECT s FROM HelpDesk s")
	public ArrayList<HelpDesk> getSupport();

}
