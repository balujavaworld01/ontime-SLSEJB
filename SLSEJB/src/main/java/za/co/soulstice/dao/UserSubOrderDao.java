package za.co.soulstice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.UserSubOrder;


public interface UserSubOrderDao extends JpaRepository<UserSubOrder, Integer>, JpaSpecificationExecutor<UserSubOrder> {

	@Query("SELECT u FROM UserSubOrder u WHERE u.orderId=:orderId AND u.threadName=:threadName")
	UserSubOrder findsubOrderByorderId(@Param("orderId") String orderId, @Param("threadName") String threadName);

}
