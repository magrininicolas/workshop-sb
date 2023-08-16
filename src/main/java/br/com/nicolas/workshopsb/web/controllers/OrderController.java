package br.com.nicolas.workshopsb.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nicolas.workshopsb.api.dto.OrderResponseDTO;
import br.com.nicolas.workshopsb.domain.entities.Order;
import br.com.nicolas.workshopsb.domain.services.OrderService;
import br.com.nicolas.workshopsb.web.maps.OrderMapper;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private OrderService service;

  public OrderController(OrderService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<OrderResponseDTO>> findAllOrders() {
    List<Order> orders = service.findAll();
    return ResponseEntity
        .ok()
        .body(orders
            .parallelStream()
            .map(OrderMapper::fromOrderToOrderResponseDTO).toList());
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderResponseDTO> findOrderById(@PathVariable(name = "id") UUID id) {
    Order order = service.findById(id);
    return ResponseEntity.ok().body(OrderMapper.fromOrderToOrderResponseDTO(order));
  }
}
