package pl.edu.pjwstk.jaz.samples.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@SuppressWarnings("JpaDataSourceORMInspection")
@Embeddable
public class CardAccessId implements Serializable {
    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "door_id")
    private Long doorId;

    public CardAccessId() {
    }

    public CardAccessId(Long cardNumber, Long doorId) {
        this.cardNumber = cardNumber;
        this.doorId = doorId;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public Long getDoorId() {
        return doorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardAccessId that = (CardAccessId) o;

        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        return doorId != null ? doorId.equals(that.doorId) : that.doorId == null;
    }

    @Override
    public int hashCode() {
        int result = cardNumber != null ? cardNumber.hashCode() : 0;
        result = 31 * result + (doorId != null ? doorId.hashCode() : 0);
        return result;
    }
}
