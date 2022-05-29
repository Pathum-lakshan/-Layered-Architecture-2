/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/28/2022
 * Time        : 12:19 AM
 * @Since : 0.1.0
 */

package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;
    boolean existItem(String code) throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    String generateNewOrderId() throws SQLException, ClassNotFoundException;
    ArrayList<CustomerDTO> loadAllCustomerIds() throws SQLException, ClassNotFoundException;
    ArrayList<ItemDTO>  loadAllItemCodes() throws SQLException, ClassNotFoundException;
}
