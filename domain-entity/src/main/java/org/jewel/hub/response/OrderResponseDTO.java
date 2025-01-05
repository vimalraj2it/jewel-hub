package org.jewel.hub.response;


import lombok.*;
import org.jewel.hub.model.OrderMaster;

import java.util.List;

/*@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder*/
public class OrderResponseDTO extends  BaseResponse{


    private List<OrderMaster> orderList;

    public List<OrderMaster> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderMaster> orderList) {
        this.orderList = orderList;
    }
}
