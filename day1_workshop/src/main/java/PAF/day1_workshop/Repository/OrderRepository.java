package PAF.day1_workshop.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import PAF.day1_workshop.Model.Customers;
import PAF.day1_workshop.Model.Orders;
import PAF.day1_workshop.Model.exception.ResourceNotFoundException;
import PAF.day1_workshop.Utils.Sql;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Orders> getOrders(int id) {
        try {

            Customers customer = template.queryForObject(Sql.getCustomersByID, BeanPropertyRowMapper.newInstance(Customers.class),
            id);

            List<Orders> orders = template.query(Sql.getOrder, 
                    BeanPropertyRowMapper.newInstance(Orders.class), 
                    id);

            return orders;

        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException(String.format("Customer with id %d is not in database", id));
        }
    }
}
