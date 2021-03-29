package s180009.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "breweries")
public class Brewery implements Serializable {

    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private long value;

    @Getter
    @Setter
    @OneToMany(mappedBy = "name", cascade = CascadeType.REMOVE)
    private List<Beer> beers = new ArrayList<>();

    @Override
    public String toString() {
        return "Brewery{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
