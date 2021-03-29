package s180009.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "beers")
public class Beer implements Serializable {

    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private long price;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "brewery")
    private Brewery brewery;

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brewery=" + brewery.getName() +
                '}';
    }
}
