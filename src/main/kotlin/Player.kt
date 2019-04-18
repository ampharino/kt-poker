class Player(val name: String, val drawPile: CardPile, var balance:Int) {
    val cards: MutableList<Card> = ArrayList()

    init {
        getStartingHand()
    }

    private fun getStartingHand() {
        cards.addAll(drawPile.drawStartingHand())
    }

    fun raise(amount: Int): Int {
        balance-=amount
        return amount
    }

}