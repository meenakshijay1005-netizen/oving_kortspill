package com.example.kortspill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private final List<PlayingCard> cards;
    private final Random random;
    private static final char[] SUITS = {'S', 'H', 'D', 'C'};

    public DeckOfCards() {
        this.cards = new ArrayList<>();
        this.random = new Random();

        for (char suit : SUITS) {
            for (int face = 1; face <= 13; face++) {
                cards.add(new PlayingCard(suit, face));
            }
        }
    }

    public List<PlayingCard> dealHand(int n) {
        if (n < 1 || n > 52) {
            throw new IllegalArgumentException("Number of cards must be between 1 and 52");
        }

        List<PlayingCard> deckCopy = new ArrayList<>(cards);
        List<PlayingCard> hand = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int randomIndex = random.nextInt(deckCopy.size());
            hand.add(deckCopy.remove(randomIndex));
        }

        return hand;
    }

    public int size() {
        return cards.size();
    }

    public List<PlayingCard> getCards() {
        return List.copyOf(cards);
    }
    
}
