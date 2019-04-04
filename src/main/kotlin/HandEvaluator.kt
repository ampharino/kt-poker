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
        if (cardTypes.contains(Ace::class)
            && cardTypes.contains(King::class)
            && cardTypes.contains(Queen::class)
            && cardTypes.contains(Jack::class)
            && cardTypes.contains(Ten::class)
            && hand.map { card -> card.suit }.toSet().size == 1
        ) {
            return RoyalFlush
        }
        if (isSequence(hand) && hand.map { card -> card.suit }.toSet().size == 1) {
            return StraightFlush
        }
        if (cardTypes.filterValues { group -> group.size == 4 }.size == 1) {
            return FourOfAKind
        }
        if (cardTypes.filterValues { group -> group.size == 3 }.size == 1
            && cardTypes.filterValues { group -> group.size == 2 }.size == 1
        ) {
            return FullHouse
        }
        if (hand.map { card -> card.suit }.toSet().size == 1) {
            return Flush
        }
        if (isSequence(hand)) {
            return Straight
        }
        if (cardTypes.filterValues { group -> group.size == 3 }.size == 1) {
            return ThreeOfAKind
        }
        if (cardTypes.filterValues { group -> group.size == 2 }.size == 2) {
            return TwoPair
        }
        if(cardTypes.filterValues { group -> group.size == 2 }.size == 1){
            return Pair
        }
        return High
    }
}

private fun isSequence(hand: List<Card>): Boolean {
    val cardSequence = hand.sortedByDescending { card -> card.value }.toMutableList()
    for (i in 1 until cardSequence.size - 1) {
        if (cardSequence[i].value == 13) {
            if (cardSequence[i + 1].value != 12 && cardSequence[i + 1].value != 4) {
                return false
            }
            continue
        }
        if (cardSequence[i].value != cardSequence[i + 1].value + 1) {
            return false
        }
    }
    return true
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