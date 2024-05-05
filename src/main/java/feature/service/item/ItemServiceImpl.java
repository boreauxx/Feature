package feature.service.item;

import feature.entity.bindings.item.AddItemModel;
import feature.entity.bindings.item.ItemModel;
import feature.entity.bindings.item.RemoveItemModel;
import feature.entity.models.Item;
import feature.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper mapper;

    @Override
    public List<ItemModel> getAllItems() {
        List<Item> items = this.itemRepository.findAll();
        List<ItemModel> mappedItems = new ArrayList<>();
        for(Item item : items){
            ItemModel model = this.mapper.map(item, ItemModel.class);
            mappedItems.add(model);
        }
        return mappedItems;
    }

    @Override
    public void addItem(AddItemModel addItemModel) {
        Item item = this.mapper.map(addItemModel, Item.class);
        this.itemRepository.save(item);
    }

    @Override
    public void removeItem(RemoveItemModel removeItem) {
        this.itemRepository.deleteById(removeItem.getId());
    }
}
