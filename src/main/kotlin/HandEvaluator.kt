import Card.*
import Hand.*

object HandEvaluator {
    fun evaluateHighestCard(highestCardHand: List<Card>): Int {
        return highestCardHand.maxBy { card -> card.value }!!.value
    }

    fun evaluatePair(pairHand: List<Card>): Int {
        val pairRank = getHighestRankFromGroupOfCards(pairHand, 2)
        return pairRank!! + Pair.value
    }


    fun evaluateTwoPair(twoPairHand: List<Card>): Int {
        val highestPairRank = getHighestRankFromGroupOfCards(twoPairHand, 2)
        return highestPairRank!! + TwoPair.value
    }

    fun evaluateThreeOfAKind(threeOfAKindHand: List<Card>): Int {
        val tripleRank = getHighestRankFromGroupOfCards(threeOfAKindHand, 3)
        return tripleRank!! + ThreeOfAKind.value
    }

    fun evaluateStraight(straightHand: List<Card>): Int {
        val topCardValue = getRankOfTopCard(straightHand)
        return topCardValue + Straight.value
    }

    fun evaluateFlush(flushHand: List<Card>): Int {
        return evaluateHighestCard(flushHand) + Flush.value
    }

    fun evaluateFullHouse(fullHouseHand: List<Card>): Int? {
        val tripleRank = getHighestRankFromGroupOfCards(fullHouseHand, 3)
        return tripleRank!! + FullHouse.value
    }

    fun evaluateFourOfAKind(fourOfAKindHand: List<Card>): Int? {
        val quartetRank = getHighestRankFromGroupOfCards(fourOfAKindHand, 4)
        return quartetRank!! + FourOfAKind.value

    }

    fun evaluateStraightFlush(straightFlushHand: List<Card>): Int? {
        val topCardValue = getRankOfTopCard(straightFlushHand)
        return topCardValue + StraightFlush.value
    }


    fun evaluateRoyalFlush(): Int? {
        return RoyalFlush.value + 1

    }

    fun determineHand(hand: List<Card>): Hand {
        val cardTypes = hand.groupBy { card -> card::class }
        val cardSuit = hand.map { card -> card.suit }.toSet()
        if (cardTypes.contains(Ace::class)
            && cardTypes.contains(King::class)
            && cardTypes.contains(Queen::class)
            && cardTypes.contains(Jack::class)
            && cardTypes.contains(Ten::class))
        {
            return RoyalFlush
        }
            return StraightFlush
    }
}

private fun getRankOfTopCard(hand: List<Card>): Int {
    val topCard = hand.maxBy { card -> card.value }
    val topCardValue =
        if (topCard is Ace && hand.any { card -> card is Five }) 4 else topCard!!.value
    return topCardValue
}

private fun getHighestRankFromGroupOfCards(cardGroup: List<Card>, groupSize: Int): Int? {
    return cardGroup
        .groupBy { card -> card.value }
        .filterValues { group -> group.size == groupSize }
        .keys
        .max()
}