package PAF.day1_workshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF.day1_workshop.Model.Customers;
import PAF.day1_workshop.Repository.CustomersRepository;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    public List<Customers> getAllCustomers(){
        return customersRepository.getAllCustomers();
    }

    public List<Customers> getAllCustomersOffsetandLimit(int offset, int limit){
        return customersRepository.getAllCustomersOffsetandLimit(offset,limit);
    }

    public Customers getCustomersByID(int id){
        return customersRepository.getCustomersByID(id);
    }

}
