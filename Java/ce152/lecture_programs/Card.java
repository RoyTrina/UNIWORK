package lectures_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card implements Comparable<Card> {

    public final static String[] SUITS = {"♣", "♦", "♥", "♠"};
    public final static String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    public final int suit;
    public final int rank;
    public final String name;

    private Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        this.name = SUITS[suit] + RANKS[rank];
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;
        Card other = (Card) obj;
        return this.suit == other.suit && this.rank == other.rank;
    }

    @Override
    public int compareTo(Card other) {
        return suit * RANKS.length + rank - other.suit * RANKS.length - other.rank;
    }

    public static List<Card> deck() {
        List<Card> result = new ArrayList<>();
        for (int i = 0; i < SUITS.length; i++)
            for (int j = 0; j < RANKS.length; j++)
                result.add(new Card(i, j));
        return result;
    }

    public static void main(String[] args) {
        List<Card> cards = deck();
        final int N = 52;
        System.out.println("### Shuffled cards");
        Collections.shuffle(cards);
        System.out.println(cards.subList(0, N));
        System.out.println("### Sorted cards (Comparable)");
        Collections.sort(cards);
        System.out.println(cards.subList(0, N));
        System.out.println("### Sorted cards (CardComparator)");
        Collections.sort(cards, new CardComparator());
        System.out.println(cards.subList(0, N));
    }

}
