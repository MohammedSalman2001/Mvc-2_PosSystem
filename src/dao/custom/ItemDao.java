package dao.custom;

import dao.CrudDao;
import model.Item;

import java.util.List;

public interface ItemDao extends CrudDao<Item, String> {
    public List<Item>searchItem();
}
