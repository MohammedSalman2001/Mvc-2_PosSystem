package bo.custom.impl;

import bo.custom.ItemBo;
import dao.custom.ItemDao;
import dao.factory.DaoFactory;
import dto.ItemDto;
import model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.ITEM);
    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new Item(
                dto.getCode(),dto.getDescription(),dto.getUnitePrice(),dto.getQtyOnHand()
        ));
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                dto.getCode(),dto.getDescription(),dto.getUnitePrice(),dto.getQtyOnHand()
        ));
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDao.delete(id);
    }

    @Override
    public List<ItemDto> searchItem(String searchText) throws SQLException, ClassNotFoundException {
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        List<Item> items = itemDao.searchItem(searchText);
        for(Item i:items){
            itemDtos.add(new ItemDto(
                    i.getCode(),
                    i.getDescription(),i.getUnitePrice(),i.getQtyOnHand()
            ));
        }
        return itemDtos;
    }
}
