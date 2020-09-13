package rtu.pract7.druncard;

class Card implements Comparable<Card> {
    final byte number;

    Card(byte number) {
        this.number = number;
    }

    public int compareTo(Card other) {
        if (this.number == 0 && other.number == 9) {
            return 1;
        }
        if (this.number == 9 && other.number == 0) {
            return -1;
        }
        return this.number - other.number;
    }
}
