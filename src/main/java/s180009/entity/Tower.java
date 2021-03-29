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
@Table(name = "towers")
public class Tower implements Serializable {

    @Id
    @Getter
    private String name;

    @Getter
    @Setter
    private int height;

    @Getter
    @Setter
    @OneToMany(mappedBy = "name", cascade = CascadeType.REMOVE)
    private List<Mage> mages = new ArrayList<>();

    @Override
    public String toString() {
        return "Tower{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

//    private String magesInTowerToString() {
//        String s ="";
//        System.out.println(mages.size());
//        for (Mage mage : mages) {
//            s += mage;
//        }
//        return s;
//    }
}
