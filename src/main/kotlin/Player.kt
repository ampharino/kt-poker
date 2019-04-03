class Player(val name: String, val drawPile: CardPile) {
    val cards: MutableList<Card> = ArrayList()


    init {
        getStartingHand()
    }

    private fun getStartingHand() {
        cards.addAll(drawPile.drawStartingHand())
    }

}