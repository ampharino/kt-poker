import Card.*
import Suit.*

class CardPile{
    val cards: MutableList<Card> = ArrayList()

    init{
        cards.add(Ace(Spade))
        cards.add(Two(Spade))
        cards.add(Three(Spade))
        cards.add(Four(Spade))
        cards.add(Five(Spade))
        cards.add(Six(Spade))
        cards.add(Seven(Spade))
        cards.add(Eight(Spade))
        cards.add(Nine(Spade))
        cards.add(Ten(Spade))
        cards.add(Jack(Spade))
        cards.add(Queen(Spade))
        cards.add(King(Spade))
    }

    fun drawStartingHand() {
    }

    fun size(): Int {
        return 52
    }

}