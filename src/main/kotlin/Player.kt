import Card.*
import Suit.*

class Player(val name:String, val drawPile:CardPile){
    val cards:MutableList<Card> = ArrayList()


    init{
        getStartingHand()
    }

    fun getStartingHand(){
        cards.add(King(Club))
        cards.add(Queen(Diamond))
        drawPile.drawStartingHand()
    }

}