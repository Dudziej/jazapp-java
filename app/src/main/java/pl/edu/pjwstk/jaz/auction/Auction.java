package pl.edu.pjwstk.jaz.auction;

import org.hibernate.annotations.Type;
import org.w3c.dom.Text;

import javax.persistence.*;
import javax.servlet.jsp.tagext.TagExtraInfo;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @Type(type = "org.postgresql.util.PGobject")
    @Column(name = "parameters")
    private Map<String,String> parameters;
    @Column(name = "price")
    private BigDecimal price;

    public Auction(Long id, String name, String description, String photo, Map<String, String> parameters, BigDecimal price) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.parameters = parameters;
        this.price = price;
    }

    public Auction() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
