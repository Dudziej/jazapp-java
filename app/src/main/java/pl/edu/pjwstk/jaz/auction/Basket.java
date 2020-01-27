package pl.edu.pjwstk.jaz.auction;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "basket")
public class Basket {
	@Id
	@JoinColumn(name = "user_id")
	private Long id;

	@JoinColumn(name = "data")
	private Date data;

	public Basket() {
	}

	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}