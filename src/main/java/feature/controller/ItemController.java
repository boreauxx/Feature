package feature.controller;

import feature.entity.bindings.AddItemModel;
import feature.entity.bindings.ItemModel;
import feature.entity.bindings.RemoveItemModel;
import feature.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllItems(){
        List<ItemModel> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestBody AddItemModel addItemModel){
        itemService.addItem(addItemModel);
        return ResponseEntity.ok("Item added successfully.");
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeItem(@RequestBody RemoveItemModel removeItem){
        itemService.removeItem(removeItem);
        return ResponseEntity.ok("Item removed successfully.");
    }
}
