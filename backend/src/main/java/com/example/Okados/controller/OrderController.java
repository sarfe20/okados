
package com.example.Okados.controller;

import com.example.Okados.model.Order;
import com.example.Okados.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService svc;
    public OrderController(OrderService svc){ this.svc = svc; }


    @PostMapping("/getOrderWithImage")
    public ResponseEntity<?> details(@RequestBody Map<String,String> body){
        String id = body.get("id");
        return svc.findById(id).map(order -> {
            var imgs = svc.gatherFirstImagesForOrder(order);
            return ResponseEntity.ok(Map.of("order", order, "imageUrl", imgs));
        }).orElse(ResponseEntity.status(404).body(Map.of("error","Order not found")));
    }


    @PostMapping("/myOrders")
    public ResponseEntity<?> byEmail(@RequestBody Map<String,String> body){
        String email = body.get("email");
        List<Order> orders = svc.findByEmail(email);
        return ResponseEntity.ok(Map.of("Orders", orders));
    }


    @PostMapping("/createorder")
    public ResponseEntity<?> create(@RequestBody Order order){
        // TODO: add cart tamper checks + shop grouping like
        Order saved = svc.save(order);
        return ResponseEntity.ok(Map.of("success", true, "orderId", saved.getId(), "message", "Your order is placed"));
    }


    @PostMapping("/cancelledOrder")
    public ResponseEntity<?> cancel(@RequestBody Map<String,String> body){
        String id = body.get("_id");
        return svc.findById(id).map(order -> {
            var ds = order.getDeliverystatus();
            if (ds == null) {
                ds = new com.example.Okados.model.DeliveryStatus();
            }
            ds.setPack("cancelled"); ds.setShipped("cancelled"); ds.setDeliver("cancelled");
            order.setDeliverystatus(ds);
            svc.save(order);
            return ResponseEntity.ok(Map.of("success", true, "message", "Order Cancelled"));
        }).orElse(ResponseEntity.status(404).body(Map.of("success", false, "message", "Order not found")));
    }
}
