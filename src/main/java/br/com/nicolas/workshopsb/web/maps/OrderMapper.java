package br.com.nicolas.workshopsb.web.maps;

import br.com.nicolas.workshopsb.api.dto.OrderResponseDTO;
import br.com.nicolas.workshopsb.domain.entities.Order;

public class OrderMapper {

  private OrderMapper(){}
  

  public static OrderResponseDTO fromOrderToOrderResponseDTO(Order order) {
    return new OrderResponseDTO(order.getInstant(), order.getClient());
  }
}
