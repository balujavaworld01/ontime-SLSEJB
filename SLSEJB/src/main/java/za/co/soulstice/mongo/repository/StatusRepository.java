package za.co.soulstice.mongo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import za.co.soulstice.mongo.model.StatusTable;

@Repository
public interface StatusRepository extends MongoRepository<StatusTable, Long> {

	Page<StatusTable> findStatusTableByInsertedtimeBetweenAndUserId(LocalDate from, LocalDate to, int userid, Pageable pageable);
	
	List<StatusTable> findStatusTableByInsertedtimeBetweenAndUserId(LocalDate from, LocalDate to, int userid);
	
	List<StatusTable> findStatusTableByInsertedtimeBetweenAndSenderId(LocalDate from, LocalDate to, String senderId);
	
	StatusTable findStatusTableBy_id(long id);
	StatusTable findStatusTableBySenderId(String senderId);
	
	List<StatusTable> findStatusTableByInsertedtimeBetween(LocalDate fromDate,LocalDate toDate);

}
