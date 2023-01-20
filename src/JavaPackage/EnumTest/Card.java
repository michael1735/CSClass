package JavaPackage.EnumTest;

import java.util.Arrays;

public class Card {
    // enum exercise
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String[] args) {
        Card card = new Card(Rank.ACE, Suit.HEART);
        System.out.println(card.getRank());
        System.out.println(card.getSuit());
        System.out.println(card);
        System.out.println(Arrays.toString(Rank.values()));
        System.out.println(Arrays.toString(Suit.values()));
    }
}
