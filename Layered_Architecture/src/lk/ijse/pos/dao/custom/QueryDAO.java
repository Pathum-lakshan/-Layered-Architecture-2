/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/27/2022
 * Time        : 5:02 AM
 * @Since : 0.1.0
 */

package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomDTO> searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException;
}
