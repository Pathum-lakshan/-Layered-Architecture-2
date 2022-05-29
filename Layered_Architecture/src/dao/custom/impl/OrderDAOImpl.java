package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.OrderDao;
import dto.OrderDTO;
import entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrderDAOImpl implements OrderDao {
    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", entity.getOid(), entity.getDate(), entity.getCustomerID());
    }

    @Override
    public boolean update(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Order search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT oid FROM `Orders` WHERE oid=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
}
