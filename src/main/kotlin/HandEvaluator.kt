import Hand.*

object HandEvaluator {
    fun evaluateHighestCard(highestCardHand: List<Card>): Int {
        return highestCardHand.maxBy { card -> card.value }!!.value
    }

    fun evaluatePair(pairHand: List<Card>): Int {
        val pairRank = pairHand
            .groupBy { card -> card.value }
            .filterValues { group -> group.size == 2 }
            .keys
            .first()

        return pairRank + Pair.value
    }

    fun evaluateTwoPair(twoPairHand: List<Card>): Int {
        val highestPairRank = twoPairHand
            .groupBy { card -> card.value }
            .filterValues { group -> group.size == 2 }
            .keys
            .max()

        return highestPairRank!! + TwoPair.value
    }

    fun evaluateThreeOfAKind(threeOfAKindHand: List<Card>): Int {
        val tripleRank = threeOfAKindHand
            .groupBy { card -> card.value }
            .filterValues { group -> group.size == 3 }
            .keys
            .max()

        return tripleRank!! + ThreeOfAKind.value
    }

    fun evaluateStraight(straightHand: List<Card>): Int {
        val topCard = straightHand.maxBy { card -> card.value }
        val topCardValue =
            if (topCard is Card.Ace && straightHand.any { card -> card is Card.Five }) 4 else topCard!!.value
        return topCardValue + Straight.value
    }

    fun evaluateFlush(flushHand: List<Card>): Int {
        return evaluateHighestCard(flushHand) + Flush.value
    }

    fun evaluateFullHouse(fullHouseHand: List<Card>): Int? {
        val tripleRank = fullHouseHand
            .groupBy { card -> card.value }
            .filterValues { group -> group.size == 3 }
            .keys
            .max()

        return tripleRank!! + FullHouse.value
    }

    fun evaluateFourOfAKind(fourOfAKindHand: List<Card>): Int? {
        val quartetRank = fourOfAKindHand
            .groupBy { card -> card.value }
            .filterValues { group -> group.size == 4 }
            .keys
            .max()

        return quartetRank!! + FourOfAKind.value

    }


}