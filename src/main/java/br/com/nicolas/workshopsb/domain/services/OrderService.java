package br.com.nicolas.workshopsb.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.nicolas.workshopsb.domain.entities.Order;
import br.com.nicolas.workshopsb.domain.repositories.OrderRepository;

@Service
public class OrderService {

  private OrderRepository repository;

  public OrderService(OrderRepository repository) {
    this.repository = repository;
  }

  public List<Order> findAll() {
    return repository.findAll();
  }

  public Order findById(UUID id) {
    return repository.findById(id).orElse(null);
  }
}

