package cursoSpringBoot.service;

import cursoSpringBoot.domain.Order;
import cursoSpringBoot.domain.OrderRepository;
import cursoSpringBoot.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order ){
        return this.orderRepository.save(order); // Inserta el producto en la bd.

    }
}
