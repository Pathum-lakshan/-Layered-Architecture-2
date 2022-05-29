/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/28/2022
 * Time        : 1:07 AM
 * @Since : 0.1.0
 */

package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ManageItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageItemsBOImpl implements ManageItemBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();

        ArrayList<ItemDTO> allCustomer = new ArrayList<>();

        for (Item item:all
             ) {
            allCustomer.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }

        return allCustomer;
    }

    public void deleteItems(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    public void saveItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.save(new Item(itemDTO.getCode(),itemDTO.getDescription() , itemDTO.getQtyOnHand(), itemDTO.getUnitPrice()));
    }

    public void updateItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(new Item(itemDTO.getCode(),itemDTO.getDescription() , itemDTO.getQtyOnHand(), itemDTO.getUnitPrice()));
    }

    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public String generateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}