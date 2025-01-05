package org.jewel.hub.order.dao;

import org.jewel.hub.model.OrderMaster;
import org.jewel.hub.response.OrderResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class OrderDAO {


    public OrderResponseDTO getOrders(String orderId) {
        OrderResponseDTO  responseDTO =  new OrderResponseDTO();
        OrderMaster order = generateRandomOrders().get(orderId);

        responseDTO.setOrderList(new ArrayList<>());
        if(order!=null){
            responseDTO.getOrderList().add(order);
        }


        return responseDTO;
    }

    private Map<String, OrderMaster> generateRandomOrders() {
        Map<String, OrderMaster> orderMap = new HashMap<>();
        OrderMaster order = new OrderMaster();
        order.setOrderId("1");
        orderMap.put("1", order);
        return orderMap;
    }

    public static void main(String[] args) {
        System.out.println("hyderabadi dum biryani".toUpperCase());
    }


}
