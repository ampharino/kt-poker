enum class Hand(val value:Int){
    High(0),
    Pair(13),
    TwoPair(26),
    ThreeOfAKind(39),
    Straight(52),
    Flush(65),
    FullHouse(78),
    FourOfAKind(91),
    StraightFlush(104),
    RoyalFlush(117);

}