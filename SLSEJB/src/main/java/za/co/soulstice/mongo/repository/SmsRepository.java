package za.co.soulstice.mongo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import za.co.soulstice.mongo.model.SMS;

@Repository
public interface SmsRepository extends MongoRepository<SMS, String> {

	Page<SMS> findSMSByUseridAndOrderid(int userid, int orderid, Pageable pageable);

	Page<SMS> findSMSByUseridAndOrderidAndStatus(int userid, int orderid, String status, Pageable pageable);

	Page<SMS> findSMSByUseridAndStatus(int userid, String status, Pageable pageable);

	Page<SMS> findSMSByStatusLikeAndOrderid(String status, int orderid, Pageable pageable);
	

}
