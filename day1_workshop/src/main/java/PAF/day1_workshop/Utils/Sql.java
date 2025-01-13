package PAF.day1_workshop.Utils;

public class Sql {
    public static final String getAllCustomers = "select * from customers";
    public static final String getAllCustomersOffsetandLimit = "select * from customers limit ? offset ?";
    public static final String getCustomersByID = "select * from customers where id = ?";


    public static final String getOrder = "select * from orders where customer_id = ?";
    
}
