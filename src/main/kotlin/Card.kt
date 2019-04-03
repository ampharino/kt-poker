sealed class Card {
    abstract val suit: Suit
    abstract val value: Int

    data class Ace(override val suit: Suit) : Card() {
        override val value: Int
            get() = 1
    }

    data class Two(override val suit: Suit) : Card() {
        override val value: Int
            get() = 2
    }

    data class Three(override val suit: Suit) : Card() {
        override val value: Int
            get() = 3
    }

    data class Four(override val suit: Suit) : Card() {
        override val value: Int
            get() = 4
    }

    data class Five(override val suit: Suit) : Card() {
        override val value: Int
            get() = 5
    }

    data class Six(override val suit: Suit) : Card() {
        override val value: Int
            get() = 6
    }

    data class Seven(override val suit: Suit) : Card() {
        override val value: Int
            get() = 7
    }

    data class Eight(override val suit: Suit) : Card() {
        override val value: Int
            get() = 8
    }

    data class Nine(override val suit: Suit) : Card() {
        override val value: Int
            get() = 9
    }

    data class Ten(override val suit: Suit) : Card() {
        override val value: Int
            get() = 10
    }

    data class Jack(override val suit: Suit) : Card() {
        override val value: Int
            get() = 11
    }

    data class Queen(override val suit: Suit) : Card() {
        override val value: Int
            get() = 12
    }

    data class King(override val suit: Suit) : Card() {
        override val value: Int
            get() = 13
    }
}