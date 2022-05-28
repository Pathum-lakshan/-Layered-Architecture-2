/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/28/2022
 * Time        : 12:31 AM
 * @Since : 0.1.0
 */

package bo.custom.impl;

import bo.custom.ManageCustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCustomerBOImpl implements ManageCustomerBO {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {
            return customerDAO.getAll();
    }

    public void saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDAO.save(customerDTO);
    }

    public void UpdateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDAO.update(customerDTO);
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
