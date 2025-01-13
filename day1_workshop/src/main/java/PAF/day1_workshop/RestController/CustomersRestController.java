package PAF.day1_workshop.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PAF.day1_workshop.Model.Customers;
import PAF.day1_workshop.Service.CustomersService;

@RestController
@RequestMapping("/api/customers")
public class CustomersRestController {
    @Autowired
    private CustomersService customersService;
    @GetMapping()
    public ResponseEntity<List<Customers>> getAllCustomers(){
        List<Customers> customers = customersService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/limit")
    public ResponseEntity<List<Customers>> getAllCustomersOffsetandLimit(
        @RequestParam(value = "limit", defaultValue = "5") int limit,
        @RequestParam(value = "offset", defaultValue = "0") int offset) {
        
        List<Customers> customers = customersService.getAllCustomersOffsetandLimit(offset, limit);
    
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerByID(@PathVariable("id") int id){
        return ResponseEntity.ok(customersService.getCustomersByID(id));
    }
    
}
