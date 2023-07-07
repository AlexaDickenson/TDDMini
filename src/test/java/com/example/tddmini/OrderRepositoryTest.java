package com.example.tddmini;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@SpringJUnitConfig
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveOrder() {
        // Create an Order object
        Order order = new Order();
        order.setCustomerName("John Doe");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("123 Main St");
        order.setTotal(100.0);

        // Save the order
        Order savedOrder = orderRepository.save(order);

        // Verify that the order is saved successfully
        assertNotNull(savedOrder.getId());
        assertEquals("John Doe", savedOrder.getCustomerName());
        assertEquals(LocalDate.now(), savedOrder.getOrderDate());
        assertEquals("123 Main St", savedOrder.getShippingAddress());
        assertEquals(100.0, savedOrder.getTotal());
    }
}
