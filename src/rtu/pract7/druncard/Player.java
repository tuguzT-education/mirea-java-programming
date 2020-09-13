package rtu.pract7.druncard;

import java.util.Stack;

class Player {
    private final Stack<Card> cards = new Stack<>();

    void addCardsDown(Card card1, Card card2) {
        addCardDown(card1);
        addCardDown(card2);
    }

    void addCardDown(Card card) {
        cards.add(0, card);
    }

    void pushToPack(Card card) {
        cards.push(card);
    }

    Card popFromPack() {
        return cards.pop();
    }

    boolean isEmptyPack() {
        return cards.isEmpty();
    }
}
