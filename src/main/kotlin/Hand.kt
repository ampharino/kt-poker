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