import Card.*

class CardPile {
    val cards: MutableList<Card> = ArrayList()

    init {
        initializeSuit(Suit.Spade)
        initializeSuit(Suit.Heart)
        initializeSuit(Suit.Club)
        initializeSuit(Suit.Diamond)

    }

    fun drawStartingHand(): List<Card> {
        return cards.removeRandomItems(2)
    }

    fun size(): Int {
        return cards.size
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

fun <T> MutableList<T>.removeRandomItems(count: Int): List<T> {
    val returnList: MutableList<T> = ArrayList()
    for (i in 1..count) {
        val item = this.random()
        this.remove(item)
        returnList.add(item)
    }
    return returnList
}