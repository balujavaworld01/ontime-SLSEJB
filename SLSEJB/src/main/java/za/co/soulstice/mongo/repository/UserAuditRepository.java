package za.co.soulstice.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import za.co.soulstice.mongo.model.SaveUserAudit;

@Repository
public interface UserAuditRepository extends MongoRepository<SaveUserAudit, String> {

}
