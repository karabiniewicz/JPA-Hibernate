package s180009.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "mages")
public class Mage implements Serializable {

    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private int level;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "tower")
    private Tower tower;

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", tower=" + tower.getName() +
                '}';
    }
}
