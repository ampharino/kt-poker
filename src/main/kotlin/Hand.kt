enum class Hand(val value: Int) {
    High(0),
    Pair(13 * 1),
    TwoPair(13 * 2),
    ThreeOfAKind(13 * 3),
    Straight(13 * 4),
    Flush(13 * 5),
    FullHouse(13 * 6),
    FourOfAKind(13 * 7),
    StraightFlush(13 * 8),
    RoyalFlush(13 * 9);
}

fun List<Card>.generatePermutations(
    remainingCards: MutableList<Card> = this.toMutableList(),
    result: List<Card>,
    size: Int
): Set<Set<Card>> {
    if (result.size == size) {
        return setOf(result.toSet())
    }
    val permutations: MutableSet<Set<Card>> = mutableSetOf()
    val newRemainingCards = remainingCards.toMutableList()
    for (card in remainingCards) {
        val newResult = result + card
        newRemainingCards.remove(card)
        permutations += generatePermutations(newRemainingCards, newResult, size)
    }
    return permutations
}