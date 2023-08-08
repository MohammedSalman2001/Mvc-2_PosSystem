package bo.custom;

import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo {
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public List<CustomerDto>searchCustomer(String searchText) throws SQLException, ClassNotFoundException;
}
