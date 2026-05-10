package za.co.soulstice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.SmppProvider;


public interface SmppProviderDao extends JpaRepository<SmppProvider, Integer>, JpaSpecificationExecutor<SmppProvider> {

	
	@Query("SELECT s FROM SmppProvider s WHERE s.name=:name AND s.route=:route")
	SmppProvider findSmppProviderByName(@Param("name") String name,@Param("route") String route);
	
	
	@Query("SELECT s FROM SmppProvider s GROUP BY s.name")
	List<SmppProvider> findAllSmppProvider();
}
