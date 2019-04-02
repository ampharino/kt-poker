sealed class Card {
    abstract val suit: Suit

    data class Ace(override val suit: Suit) : Card()
    data class Two(override val suit: Suit) : Card()
    data class Three(override val suit: Suit) : Card()
    data class Four(override val suit: Suit) : Card()
    data class Five(override val suit: Suit) : Card()
    data class Six(override val suit: Suit) : Card()
    data class Seven(override val suit: Suit) : Card()
    data class Eight(override val suit: Suit) : Card()
    data class Nine(override val suit: Suit) : Card()
    data class Ten(override val suit: Suit) : Card()
    data class Jack(override val suit: Suit) : Card()
    data class Queen(override val suit: Suit) : Card()
    data class King(override val suit: Suit) : Card()
}