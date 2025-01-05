package org.jewel.hub.order.controller;

import org.jewel.hub.request.OrderRequestDTO;
import org.jewel.hub.response.OrderResponseDTO;
import org.jewel.hub.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/status/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable String orderId) {
        return service.getOrder(orderId);
    }

    @GetMapping("/create")
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return service.createOrder(orderRequestDTO.getOrder());
    }


}
