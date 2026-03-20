package com.example.kortspill;

import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {
    private final List<PlayingCard> cards;

    public HandOfCards(List<PlayingCard> cards) {
        if (cards == null || cards.size() < 5) {
            throw new IllegalArgumentException("A hand must contain at least 5 cards");
        }
        this.cards = List.copyOf(cards);
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public String cardsAsString() {
        return cards.stream()
        .map(PlayingCard::toString)
        .collect(Collectors.joining(" "));
    }

    public int sumOfFaces() {
        return cards.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
    }

    public String heartsAsString() {
        return cards.stream()
        .filter(card -> card.getSuit() == 'H')
        .map(PlayingCard::toString)
        .collect(Collectors.collectingAndThen(
            Collectors.joining(" "),
            result -> result.isBlank() ? "No Hearts" : result
                ));
    }

    public boolean hasQueenOfSpades() {
        return cards.stream()
        .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
    }

    public boolean hasFlush() {
        return cards.stream()
        .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
        .values().stream()
        .anyMatch(count -> count >= 5);
    }
    
}
