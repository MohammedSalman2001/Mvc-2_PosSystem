package dao.custom.impl;

import dao.custom.ItemDao;
import model.Item;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImp implements ItemDao {
    @Override
    public boolean save(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO item VALUES(?,?,?,?)",item.getCode(),item.getDescription(),item.getUnitePrice(),item.getQtyOnHand());
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("UPDATE item SET description=?,unitePrice=?,qtyOnHand=? WHERE code=?",
                item.getDescription(),item.getUnitePrice(),item.getQtyOnHand(),item.getCode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM item WHERE code=?",id);
    }

    @Override
    public List<Item> searchItem(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<Item> arrayList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM item WHERE code LIKE ? || description LIKE ?",searchText,searchText);
        while (resultSet.next()){
            arrayList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4))

            );
        }
        return arrayList;
    }
}
