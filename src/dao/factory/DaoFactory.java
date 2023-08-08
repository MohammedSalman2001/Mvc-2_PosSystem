package dao.factory;

import dao.custom.impl.CustomerDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;


    public enum DaoType{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,QUERY
    }

    private DaoFactory(){

    }

    public static DaoFactory getDaoFactory(){
        return daoFactory==null?daoFactory=new DaoFactory():daoFactory;
    }

    public <T> T getDao( DaoType daoType){
        switch (daoType){
            case CUSTOMER:
                return (T) new CustomerDaoImpl();

            default:
                return null;

        }

    }


}
