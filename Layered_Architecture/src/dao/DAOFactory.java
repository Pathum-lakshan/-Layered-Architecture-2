/**
 * @author : ALE_IS_TER
 * Project Name: Layered_Architecture
 * Date        : 5/28/2022
 * Time        : 5:11 AM
 * @Since : 0.1.0
 */

package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        if (daoFactory == null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERYDAO
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
