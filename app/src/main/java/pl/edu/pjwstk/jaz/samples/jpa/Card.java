package pl.edu.pjwstk.jaz.samples.jpa;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
    @Id
    private Long number;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "card_holder_id")
    private CardHolder cardHolder;

    public Card(Long number, CardType cardType, CardHolder cardHolder) {
        this.number = number;
        this.cardType = cardType;
        this.cardHolder = cardHolder;
    }

    public Card() {
    }

    public Long getNumber() {
        return number;
    }

    public CardType getCardType() {
        return cardType;
    }
}
