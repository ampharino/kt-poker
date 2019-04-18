class Player(val name: String, val drawPile: CardPile, var balance: Int) {
    val cards: MutableList<Card> = ArrayList()

    init {
        getStartingHand()
    }

    private fun getStartingHand() {
        cards.addAll(drawPile.drawStartingHand())
    }

    fun raise(amount: Int): Int {
        if (amount > balance) throw(NotEnoughBalanceException("Bet amount is more than balance!"))
        balance -= amount
        return amount
    }

}