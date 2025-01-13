package PAF.day1_workshop.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PAF.day1_workshop.Model.Orders;
import PAF.day1_workshop.Service.OrdersService;

@RestController
@RequestMapping("/api/customers")
public class OrderRestController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<Orders>> getCustomerByID(@PathVariable("id") int id) {

        return ResponseEntity.ok(ordersService.getOrders(id));
    }

}
