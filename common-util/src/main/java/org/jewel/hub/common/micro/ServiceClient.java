package org.jewel.hub.common.micro;


import org.jewel.hub.common.exception.JewelServiceException;
import org.jewel.hub.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


@Component
public class ServiceClient {
    @Autowired
    private RestTemplate template;

    public BaseResponse fetch(String url, Class<? extends BaseResponse> responseClass) throws JewelServiceException {
        BaseResponse baseResponse=null;
        try {

            // url -> "http://ORDER-SERVICE/restaurant/orders/status/" + orderId
            baseResponse = template.getForObject(url,
                    responseClass);

        } catch (HttpServerErrorException errorException) {
            /*log.error("RestaurantServiceClient::fetchOrderStatus caught the HttpServer server error {}",
                    errorException.getResponseBodyAsString());*/
            throw new JewelServiceException(errorException.getResponseBodyAsString());
        } catch (Exception ex) {
            //log.error("RestaurantServiceClient::fetchOrderStatus caught the generic error {}", ex.getMessage());

        }
        return baseResponse;
    }
}
