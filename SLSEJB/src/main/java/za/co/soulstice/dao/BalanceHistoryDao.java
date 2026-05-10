
package za.co.soulstice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import za.co.soulstice.model.BalanceHistory;


public interface BalanceHistoryDao
		extends JpaRepository<BalanceHistory, Integer>, JpaSpecificationExecutor<BalanceHistory> {

	
	@Query("SELECT a FROM BalanceHistory a ORDER BY a.balanceAddedDate DESC")
	ArrayList<BalanceHistory> getAllHistory();

	
	@Query("SELECT u FROM BalanceHistory u WHERE u.userId=:userId ORDER BY u.balanceAddedDate DESC")
	List<BalanceHistory> getAllHistoryBasedOnUserId(@Param("userId") int userId);
	
	@Query(value="SELECT balance+taxAmmount FROM user_account_history u WHERE u.userId=:userId order by id desc LIMIT 1",nativeQuery = true)
	Double getLatestBalanceHistory(@Param("userId") int userId);
	
	

	@Query("SELECT u FROM BalanceHistory u WHERE u.invoiceNumber=:invoiceNumber")
	BalanceHistory getPurchaseHistoryBasedOnInvoice(@Param("invoiceNumber") String invoiceNumber);
	
	
}
