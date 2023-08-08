package dao.custom.impl;

import dao.custom.ItemDao;
import model.Item;
import util.CrudUtil;

import java.sql.SQLException;
import java.util.List;

public class ItemDaoImp implements ItemDao {
    @Override
    public boolean save(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO item VALUES(?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitePrice(),item.getQtyOnHand());
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE item SET description=?,unitePrice=?,qtyOnHand")
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Item> searchItem() {
        return null;
    }
}
