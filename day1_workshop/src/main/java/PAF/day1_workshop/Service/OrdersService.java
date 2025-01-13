package PAF.day1_workshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF.day1_workshop.Model.Orders;
import PAF.day1_workshop.Repository.OrderRepository;

@Service
public class OrdersService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getOrders(int id){

        return orderRepository.getOrders(id);
        
    }
}
