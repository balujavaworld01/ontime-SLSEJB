package za.co.soulstice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.UserOrder;

public interface UserOrderDao extends JpaRepository<UserOrder, Long>{

	
	@Query("SELECT u FROM UserOrder u WHERE u.scheduleStatus='PENDING' AND u.scheduledDate BETWEEN :startDate AND :endDate")
	List<UserOrder> findByScheduledDate(@Param("endDate") Date startDate, @Param("endDate") Date endDate);

	
	@Query("SELECT u FROM UserOrder u where u.user.userId=:userId AND u.scheduleStatus IS NOT NULL")
	ArrayList<UserOrder> findUserOrderByUserId(@Param("userId") long userId);

	
	@Query("SELECT u FROM UserOrder u where u.user.userId=:userId")
	ArrayList<UserOrder> findAllOrderIdsByUSer(@Param("userId") long userId);

	
	@Query("SELECT u FROM UserOrder u WHERE u.orderId=:orderId")
	UserOrder getOrderById(@Param("orderId") long orderId);
	
	@Query("SELECT u FROM UserOrder u WHERE u.user.userId=:userId AND orderDate BETWEEN :fromDate AND :toDate AND (u.scheduleStatus='COMPLETED' OR u.scheduleStatus IS NULL)")
	ArrayList<UserOrder> getJobIdsByUserIdAndDates(@Param("fromDate") Date fromDate,@Param("toDate") Date toDate,@Param("userId") long userId);
}
