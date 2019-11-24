package pl.edu.pjwstk.jaz.samples.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "card_access")
public class CardAccess {
    @EmbeddedId
    private CardAccessId cardAccessId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("cardNumber")
    @JoinColumn(name = "card_number")
    private Card card;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("doorId")
    @JoinColumn(name = "door_id")
    private Door door;

    @Column(name = "start_hour")
    private Integer startHour;

    @Column(name = "end_hour")
    private Integer endHour;

    public CardAccess() {
    }

    public CardAccess(Card card, Door door, Integer startHour, Integer endHour) {
        this.cardAccessId = new CardAccessId();
        this.card = card;
        this.door = door;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public CardAccessId getCardAccessId() {
        return cardAccessId;
    }

    public Card getCard() {
        return card;
    }

    public Door getDoor() {
        return door;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }
}
