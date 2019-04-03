import Card.*

class CardPile {
    val cards: MutableList<Card> = ArrayList()

    init {
        initializeSuit(Suit.Spade)
        initializeSuit(Suit.Heart)
        initializeSuit(Suit.Club)
        initializeSuit(Suit.Diamond)

    }

    fun drawStartingHand() {
    }

    fun size(): Int {
        return 52
    }

    private fun initializeSuit(suit: Suit) {
        cards.add(Ace(suit))
        cards.add(Two(suit))
        cards.add(Three(suit))
        cards.add(Four(suit))
        cards.add(Five(suit))
        cards.add(Six(suit))
        cards.add(Seven(suit))
        cards.add(Eight(suit))
        cards.add(Nine(suit))
        cards.add(Ten(suit))
        cards.add(Jack(suit))
        cards.add(Queen(suit))
        cards.add(King(suit))
    }

}