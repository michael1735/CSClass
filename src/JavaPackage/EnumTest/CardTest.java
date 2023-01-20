package JavaPackage.EnumTest;

import java.util.Arrays;

public class CardTest {
    private static Card[] cards = new Card[52];

    public static void main(String[] args) {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Card(rank, suit);
            }
        }
        System.out.println(Arrays.toString(cards));
    }
}
