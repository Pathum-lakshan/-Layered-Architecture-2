/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/28/2022
 * Time        : 12:31 AM
 * @Since : 0.1.0
 */

package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ManageCustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCustomerBOImpl implements ManageCustomerBO {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {

        ArrayList<Customer> all = customerDAO.getAll();

        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();

        for (Customer customer: all
             ) {
            allCustomer.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        }

        return allCustomer;
    }

    public void saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDAO.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));
    }

    public void UpdateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDAO.update(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        customerDAO.delete(id);
    }

    public String generateNewId () throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }

}
