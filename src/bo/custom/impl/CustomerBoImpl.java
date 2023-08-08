package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.custom.CustomerDao;
import dao.factory.DaoFactory;
import dto.CustomerDto;
import model.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao= DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        return customerDao.save(
                new Customer(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),customerDto.getSalary())
        );
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        return customerDao.update(
                new Customer(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),customerDto.getSalary())
        );
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public List<CustomerDto> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {
        List<Customer> customers = customerDao.searchCustomer(searchText);
        ArrayList<CustomerDto> arrayList = new ArrayList<>();
        for(Customer c:customers){
            arrayList.add(new CustomerDto(
                    c.getId(),
                    c.getName(),
                    c.getAddress(),
                    c.getSalary()
            ));
        }
        return arrayList;
    }
}
