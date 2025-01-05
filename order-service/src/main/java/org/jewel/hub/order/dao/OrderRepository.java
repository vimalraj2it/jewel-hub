package org.jewel.hub.order.dao;

import org.jewel.hub.model.OrderMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository  extends MongoRepository<OrderMaster, String> {
    // Custom query methods can be defined here
    List<OrderMaster> findByName(String name);

}
