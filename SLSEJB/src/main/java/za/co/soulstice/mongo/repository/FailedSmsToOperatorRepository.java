package za.co.soulstice.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import za.co.soulstice.mongo.model.FailedSmsToOperatorData;

public interface FailedSmsToOperatorRepository extends MongoRepository<FailedSmsToOperatorData, String> {

	List<FailedSmsToOperatorData> getFailedSMSDataByStatus(String status);

}
