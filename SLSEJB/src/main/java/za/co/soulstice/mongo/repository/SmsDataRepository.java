package za.co.soulstice.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import za.co.soulstice.mongo.model.SmsDataModel;

public interface SmsDataRepository extends MongoRepository<SmsDataModel,String> {
	
	@Query("{'numAndOrderSerialNumber.orderSerialId' : {$gt : ?0, $lt : ?1}}")
	List<SmsDataModel> findUsersByName(String from,String to);
	
	
	
	
	
}
	