package bo.factory;

import bo.custom.impl.CustomerBoImpl;
import bo.custom.impl.ItemBoImpl;
import dao.custom.impl.CustomerDaoImpl;

public class BoFactory {
    private static BoFactory BoFactory;


    public enum BoType{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,QUERY
    }

    private BoFactory(){

    }

    public static BoFactory getDaoFactory(){
        return BoFactory==null?BoFactory=new BoFactory():BoFactory;
    }

    public <T> T getBo( BoType BoType){
        switch (BoType){
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case ITEM:
                return (T) new ItemBoImpl();

            default:
                return null;

        }

    }


}
