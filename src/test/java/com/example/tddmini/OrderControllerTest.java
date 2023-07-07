package com.example.tddmini;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder_WithValidData_ShouldReturn200() throws Exception {
        String orderJson = "{ \"customerName\": \"John Doe\", \"orderDate\": \"2023-07-07\", " +
                "\"shippingAddress\": \"123 Main St\", \"total\": 100.0 }";

        mockMvc.perform(MockMvcRequestBuilders.post("/orders/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateOrder_WithMissingCustomerName_ShouldReturn400() throws Exception {
        String orderJson = "{ \"orderDate\": \"2023-07-07\", " +
                "\"shippingAddress\": \"123 Main St\", \"total\": 100.0 }";

        mockMvc.perform(MockMvcRequestBuilders.post("/orders/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testCreateOrder_WithNegativeTotal_ShouldReturn400() throws Exception {
        String orderJson = "{ \"customerName\": \"John Doe\", \"orderDate\": \"2023-07-07\", " +
                "\"shippingAddress\": \"123 Main St\", \"total\": -100.0 }";

        mockMvc.perform(MockMvcRequestBuilders.post("/orders/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


}
