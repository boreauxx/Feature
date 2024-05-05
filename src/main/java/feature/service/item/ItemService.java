package feature.service.item;

import feature.entity.bindings.item.AddItemModel;
import feature.entity.bindings.item.ItemModel;
import feature.entity.bindings.item.RemoveItemModel;

import java.util.List;

public interface ItemService {

    List<ItemModel> getAllItems();

    void addItem(AddItemModel addItemModel);

    void removeItem(RemoveItemModel removeItem);
}
