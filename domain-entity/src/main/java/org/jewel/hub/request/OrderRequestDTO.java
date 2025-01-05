package org.jewel.hub.request;

import org.jewel.hub.model.OrderMaster;

public class OrderRequestDTO {

    private OrderMaster order;

    public OrderMaster getOrder() {
        return order;
    }

    public void setOrder(OrderMaster order) {
        this.order = order;
    }
}
