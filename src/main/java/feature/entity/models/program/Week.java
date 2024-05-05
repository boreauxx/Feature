package feature.entity.models.program;

import feature.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "weeks")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Week extends BaseEntity {

    @OneToMany(mappedBy = "week", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Day> days;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
}
