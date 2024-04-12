package feature.entity.models;

import feature.util.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "exercises")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Exercise extends BaseEntity {

    private String name;

    private Integer sets;

    private Double kg;

    @ManyToMany(mappedBy = "exercises")
    private List<Program> programs;
}
