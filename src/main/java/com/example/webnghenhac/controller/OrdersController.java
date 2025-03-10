package com.example.webnghenhac.controller;

import com.example.webnghenhac.dto.OrdersSimpleDTO;
import com.example.webnghenhac.dto.request.OrdersCreationRequest;
import com.example.webnghenhac.dto.request.OrdersUpdateRequest;
import com.example.webnghenhac.entity.Orders;
import com.example.webnghenhac.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public List<OrdersSimpleDTO> getAllOrders() {
        return ordersService.getAllOrders().stream()
                .map(OrdersSimpleDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable("id") int id) {
        return ordersService.getOrderById(id);
    }

    @PostMapping
    public Orders createOrder(@RequestBody OrdersCreationRequest request) {
        return ordersService.createOrder(request);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable("id") int id, @RequestBody OrdersUpdateRequest request) {
        return ordersService.updateOrder(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        ordersService.deleteOrder(id);
        return "Order has been deleted";
    }
}