package org.jewel.hub.order.service;

import org.jewel.hub.model.OrderMaster;
import org.jewel.hub.order.dao.OrderRepository;
import org.jewel.hub.response.OrderResponseDTO;
import org.jewel.hub.order.dao.OrderDAO;
import org.jewel.hub.order.exception.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderRepository orderRepository;

    public String greeting() {
        return "Welcome to Order service";
    }

    public OrderResponseDTO getOrder(String orderId) {
        Optional<OrderMaster> optOrder = orderRepository.findById(orderId);
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO() ;
        if (optOrder.isPresent()) {
            orderResponseDTO.setOrderList(new ArrayList<>());
            orderResponseDTO.getOrderList().add(optOrder.get());

        } else {
            orderResponseDTO.setStatus(HttpStatus.NOT_FOUND);
            orderResponseDTO.setErrorMessage("Order not available with id :" + orderId);
        }

        return orderResponseDTO;
    }

    public OrderResponseDTO createOrder(OrderMaster order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO() ;
        orderRepository.save(order);

        orderResponseDTO.setOrderList(new ArrayList<>());
        orderResponseDTO.getOrderList().add(order);

        return orderResponseDTO;
    }
}
