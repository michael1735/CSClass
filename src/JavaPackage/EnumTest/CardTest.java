package JavaPackage.EnumTest;

import java.util.Arrays;

public class CardTest {
    private static final Card[] cards = new Card[52];

    public static void main(String[] args) {
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[i++] = new Card(rank, suit);
            }
        }
        System.out.println(Arrays.toString(cards));
        cards[0] = new Card(Rank.ACE, Suit.HEART);
        System.out.println(Arrays.toString(cards));

        /*
        对于一个final变量:
        如果是基本类型, 则其数值在初始化后就不能更改;
        如果是引用类型, 对其初始化后便不能再让其指向另一个对象
         */
    }
}
