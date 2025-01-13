package PAF.day1_workshop.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import PAF.day1_workshop.Model.Customers;
import PAF.day1_workshop.Model.exception.ResourceNotFoundException;
import PAF.day1_workshop.Utils.Sql;

@Repository
public class CustomersRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Customers> getAllCustomers() {
        List<Customers> customers = new ArrayList<>();
        SqlRowSet result = template.queryForRowSet(Sql.getAllCustomers);
        System.out.println(result);

        while (result.next()) {
            Customers customer = new Customers(result.getInt("id"), result.getString("company"),
                    result.getString("last_name"), result.getString("first_name"), result.getString("email_address"),
                    result.getString("job_title"), result.getString("business_phone"), result.getString("home_phone"),
                    result.getString("mobile_phone"), result.getString("fax_number"), result.getString("address"),
                    result.getString("city"), result.getString("state_province"), result.getString("zip_postal_code"),
                    result.getString("country_region"), result.getString("web_page"), result.getString("notes"));
            customers.add(customer);
        }

        return customers;
    }

    public List<Customers> getAllCustomersOffsetandLimit(int offset, int limit) {
        List<Customers> customers = new ArrayList<>();
        SqlRowSet result = template.queryForRowSet(Sql.getAllCustomersOffsetandLimit, limit, offset);

        while (result.next()) {
            Customers customer = new Customers(result.getInt("id"), result.getString("company"),
                    result.getString("last_name"), result.getString("first_name"), result.getString("email_address"),
                    result.getString("job_title"), result.getString("business_phone"), result.getString("home_phone"),
                    result.getString("mobile_phone"), result.getString("fax_number"), result.getString("address"),
                    result.getString("city"), result.getString("state_province"), result.getString("zip_postal_code"),
                    result.getString("country_region"), result.getString("web_page"), result.getString("notes"));
            customers.add(customer);
        }

        return customers;
    }

    public Customers getCustomersByID(int id) {
        Customers customer = null;
        try {
            customer = template.queryForObject(Sql.getCustomersByID, BeanPropertyRowMapper.newInstance(Customers.class),
                    id);

            return customer;
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException(String.format("Customer with id %d is not in database", id));
        }
    }
}
