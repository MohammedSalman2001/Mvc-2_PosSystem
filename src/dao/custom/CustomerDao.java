package dao.custom;

import dao.CrudDao;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends CrudDao<Customer,String> {
    public List<Customer>searchCustomer(String searchText) throws SQLException, ClassNotFoundException;
}
