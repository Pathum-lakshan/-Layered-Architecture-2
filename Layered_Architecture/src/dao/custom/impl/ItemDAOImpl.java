package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getBigDecimal(4)));
        }
        return allItems;
    }

    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", entity.getCode(), entity.getDescription(), entity.getUnitPrice(), entity.getQtyOnHand());
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", entity.getDescription(), entity.getUnitPrice(), entity.getQtyOnHand(), entity.getCode());
    }

    @Override
    public Item search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item WHERE code=?", s);
        if (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getBigDecimal(4));
        }
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", s).next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?", s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

}
