/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/28/2022
 * Time        : 9:43 AM
 * @Since : 0.1.0
 */

package lk.ijse.pos.bo;


import lk.ijse.pos.bo.custom.impl.ManageCustomerBOImpl;
import lk.ijse.pos.bo.custom.impl.ManageItemsBOImpl;
import lk.ijse.pos.bo.custom.impl.PlaceOrderBOImpl;


public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        if (boFactory == null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        MANAGECUSTOMER,MANAGEITEM,PLACEORDER
    }


    //method for hide the object creation logic and return what client wants
    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case MANAGECUSTOMER:
                return new ManageCustomerBOImpl();
            case MANAGEITEM:
                return new ManageItemsBOImpl();
            case PLACEORDER:
                return  new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
