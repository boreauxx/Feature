package feature.service.item;

import feature.entity.bindings.AddItemModel;
import feature.entity.bindings.ItemModel;
import feature.entity.bindings.RemoveItemModel;

import java.util.List;

public interface ItemService {

    List<ItemModel> getAllItems();

    void addItem(AddItemModel addItemModel);

    void removeItem(RemoveItemModel removeItem);
}
