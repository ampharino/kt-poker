import Hand.*

object HandEvaluator {
    fun evaluateHighestCard(highestCardHand: List<Card>): Int {
        return highestCardHand.maxBy { card -> card.value }!!.value
    }

    fun evaluatePair(pairHand: List<Card>): Int? {
        val pairRank = pairHand
            .groupBy { card -> card.value }
            .filterValues { group -> group.size == 2 }
            .keys
            .first()

        return pairRank + Pair.value
    }

    fun evaluateTwoPair(twoPairHand: List<Card>): Int? {
        val highestPairRank = twoPairHand
            .groupBy { card -> card.value }
            .filterValues { group -> group.size == 2 }
            .keys
            .max()

        return highestPairRank!! + TwoPair.value

    }
}