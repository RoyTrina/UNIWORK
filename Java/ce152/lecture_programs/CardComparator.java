package lectures_programs;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    public int compare(Card c1, Card c2) {
        return c1.rank * Card.SUITS.length + c1.rank
                - c2.rank * Card.SUITS.length - c2.rank;
    }
}
