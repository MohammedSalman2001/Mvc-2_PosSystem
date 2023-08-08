package dao.factory;

import dao.custom.impl.CustomerDaoImpl;
import dao.custom.impl.ItemDaoImp;

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

            case ITEM:
                return (T) new ItemDaoImp();
            default:
                return null;

        }

    }


}
