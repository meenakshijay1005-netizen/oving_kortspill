package com.example.kortspill;

public class PlayingCard {
    public PlayingCard(char suit, int face) {
        if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
            throw new IllegalArgumentException("Suit must be one of S, H, D, C");
        }
        if (face < 1 || face > 13) {
            throw new IllegalArgumentException("Face must be between 1 and 13");
        }

        this.suit = suit;
        this.face = face;
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    @Override
    public String toString() {
        return "" + suit + face;
    }
    
}
