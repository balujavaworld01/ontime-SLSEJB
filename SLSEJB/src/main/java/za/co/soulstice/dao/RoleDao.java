package za.co.soulstice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.soulstice.model.Role;


public interface RoleDao extends JpaRepository<Role, Long>,JpaSpecificationExecutor<Role> {
	
	
	@Query("SELECT r FROM Role r WHERE r.roleId=:roleId")
	Role findRoleById(@Param("roleId") long roleId);

}
