package br.com.nicolas.workshopsb.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.nicolas.workshopsb.domain.entities.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_orders")
@Table(name = "tb_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @CreatedDate
  @Column(name = "order_date")
  private Instant instant;

  private Integer orderStatus;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  public Order(UUID id, Instant instant, OrderStatus orderStatus, User client) {
    this.id = id;
    this.instant = instant;
    setOrderStatus(orderStatus);
    this.client = client;
  }

  public OrderStatus getOrderStatus() {
    return OrderStatus.valueOf(orderStatus);
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    if (orderStatus != null) {
      this.orderStatus = orderStatus.getCode();
    }
  }
}
