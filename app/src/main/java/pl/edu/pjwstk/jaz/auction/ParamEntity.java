package pl.edu.pjwstk.jaz.auction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parameter")
public class ParamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "parameters")
    private Set<Auction> auctions;

    public ParamEntity() {
    }

    public ParamEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
