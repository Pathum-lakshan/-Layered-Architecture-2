/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/28/2022
 * Time        : 1:07 AM
 * @Since : 0.1.0
 */

package bo.custom.impl;

import bo.custom.ManageItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageItemsBOImpl implements ManageItemBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException {
         return itemDAO.getAll();
    }

    public void deleteItems(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    public void saveItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.save(itemDTO);
    }

    public void updateItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(itemDTO);
    }

    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public String generateNewId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }
}