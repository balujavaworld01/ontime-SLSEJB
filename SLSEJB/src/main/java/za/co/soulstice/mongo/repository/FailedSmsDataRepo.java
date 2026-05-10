package za.co.soulstice.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import za.co.soulstice.mongo.model.FailedSmsDataModel;

public interface FailedSmsDataRepo extends MongoRepository<FailedSmsDataModel, Long> {
	
	List<FailedSmsDataModel> getFailedSMSOrdersByCompleted(Boolean completed);

}
