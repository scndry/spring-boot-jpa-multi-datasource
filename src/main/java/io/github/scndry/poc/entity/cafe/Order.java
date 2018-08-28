package io.github.scndry.poc.entity.cafe;

import io.github.scndry.poc.code.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @ManyToOne
    private Customer customer;
    private OrderStatus orderStatus;
    @ElementCollection
    @CollectionTable(name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "item"}))
    @Column(name = "item")
    private Set<String> items;
}
