package za.co.soulstice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import za.co.soulstice.model.UserSupport;


public interface UserSupportDao extends JpaRepository<UserSupport, Integer>, JpaSpecificationExecutor<UserSupport> {

}
