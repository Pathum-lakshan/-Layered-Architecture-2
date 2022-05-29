/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/27/2022
 * Time        : 10:25 AM
 * @Since : 0.1.0
 */

package bo.custom.impl;

import bo.custom.PlaceOrderBO;
import dao.DAOFactory;
import dao.custom.*;
import db.DBConnection;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Item;
import entity.Order;
import entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    private final DAOFactory daoFactory =  DAOFactory.getDaoFactory();

    private final CustomerDAO customerDAO = (CustomerDAO) daoFactory.getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final ItemDAO itemDAO = (ItemDAO) daoFactory.getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDao orderDAO = (OrderDao) daoFactory.getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) daoFactory.getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    private final QueryDAO queryDAO = (QueryDAO) daoFactory.getDAO(DAOFactory.DAOTypes.QUERYDAO);

    public boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        /*Transaction*/

        Connection connection = DBConnection.getDbConnection().getConnection();
        /*if order id already exist*/
        if (orderDAO.exist(orderDTO.getOrderId())) {

        }

        connection.setAutoCommit(false);
        boolean save = orderDAO.save(new Order(orderDTO.getOrderId(), orderDTO.getOrderDate(), orderDTO.getCustomerId()));

        if (!save) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        for (OrderDetailDTO detail : orderDTO.getOrderDetails()) {
            boolean save1 = orderDetailsDAO.save(new OrderDetails(detail.getOid(),detail.getItemCode(),detail.getQty(),detail.getUnitPrice()));
            if (!save1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            //Search & Update Item
            ItemDTO item = searchItem(detail.getItemCode());

            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            //update item

            boolean update = itemDAO.update(new Item(item.getCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice()));

            if (!update) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }
        connection.commit();
        connection.setAutoCommit(true);
        return true;


    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.search(code);
    }

    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }


    public String generateNewOrderId() throws SQLException, ClassNotFoundException {

            return orderDAO.generateNewID();

    }
    public ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException {

       return customerDAO.getAll();

    }

    public   ArrayList<ItemDTO>  loadAllItemCodes() throws SQLException, ClassNotFoundException {

           return itemDAO.getAll();

    }
}

