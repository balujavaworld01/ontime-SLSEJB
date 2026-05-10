package za.co.soulstice.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import za.co.soulstice.mongo.model.OrderCost;

public interface OrderCostRepo extends MongoRepository<OrderCost, Long> {
	

}
