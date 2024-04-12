package feature.entity.bindings;

import lombok.Data;

@Data
public class AddItemModel {

    private String name;
    private Integer fats;
    private Integer carbs;
    private Integer protein;
    private Integer calories;
}
