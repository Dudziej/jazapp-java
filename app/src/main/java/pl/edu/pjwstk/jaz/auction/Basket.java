package pl.edu.pjwstk.jaz.auction;



import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="basket")
public class Basket {
    @Id
    @JoinColumn(name = "user_id")
    private Long id;

    @JoinColumn(name = "data")
    private Date data;


    public Basket{
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}