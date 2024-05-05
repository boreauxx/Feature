package feature.entity.bindings.item;

import lombok.Data;

@Data
public class ItemModel {

    private Long id;
    private String name;
    private Integer fats;
    private Integer carbs;
    private Integer protein;
    private Integer calories;
}
