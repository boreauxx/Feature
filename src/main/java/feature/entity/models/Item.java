package feature.entity.models;

import feature.util.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Item extends BaseEntity {

    private String name;

    private Integer fats;

    private Integer carbs;

    private Integer protein;

    private Integer calories;
}
