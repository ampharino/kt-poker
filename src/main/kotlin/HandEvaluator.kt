object HandEvaluator {
    fun evaluateHighestCard(highestCardHand: List<Card>): Int {
        return highestCardHand.maxBy { card -> card.value }!!.value
    }
}