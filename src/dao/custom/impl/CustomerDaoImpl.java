package dao.custom.impl;

import dao.custom.CustomerDao;
import model.Customer;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer c1) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO CUSTOMER VALUES (?,?,?,?)",
                c1.getId(),c1.getName(),c1.getAddress(),c1.getSalary());
    }

    @Override
    public  boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE Customer SET customerName=?,customerAddress=?,customerSalary=? WHERE customerId=?",
                customer.getName(),customer.getAddress(),customer.getSalary(),customer.getId());
    }

    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM Customer WHERE customerId=?",id);
    }

    @Override
    public List<Customer> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<Customer> arrayList = new ArrayList<>();
        ResultSet resultSet= CrudUtil.execute("SELECT * FROM customer WHERE customerName LIKE ? || customerAddress LIKE ?",searchText,searchText);

        while (resultSet.next()){
            arrayList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }
        return arrayList;
    }
}
