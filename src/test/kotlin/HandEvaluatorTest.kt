import Card.*
import Hand.*
import Suit.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

private const val JACK_VALUE = 10
private const val ACE_VALUE = 13
private const val FOUR_VALUE = 3
private const val SEVEN_VALUE = 6
private const val NINE_VALUE = 8
private const val FIVE_VALUE = 4
private const val TEN_VALUE = 9
private const val EIGHT_VALUE = 7

internal class HandEvaluatorTest {
    @Test
    fun shouldReturnValueOfHighestCardForHighCardHand() {
        val handValue = HandEvaluator.evaluateHighestCard(highestCardHand())
        assertThat(handValue, equalTo(JACK_VALUE))
    }

    @Test
    fun shouldReturnValueOfCardInPairAddedToValueOfPairHand() {
        val handValue = HandEvaluator.evaluatePair(pairHand())
        assertThat(handValue, equalTo(Pair.value + ACE_VALUE))
    }

    @Test
    fun shouldReturnHighestRankPairAddedToValueOfTwoPairHand() {
        val handValue = HandEvaluator.evaluateTwoPair(twoPairHand())
        assertThat(handValue, equalTo(TwoPair.value + FOUR_VALUE))
    }

    @Test
    fun shouldReturnValueOfTripletAddedToValueOfThreeOfAKindHand() {
        val handValue = HandEvaluator.evaluateThreeOfAKind(threeOfAKindHand())
        assertThat(handValue, equalTo(SEVEN_VALUE + ThreeOfAKind.value))
    }

    @Test
    fun shouldReturnValueOfTopCardInStraightAddedToValueOfStraightHand() {
        val handValue = HandEvaluator.evaluateStraight(straightHand())
        assertThat(handValue, equalTo(NINE_VALUE + Straight.value))
    }

    @Test
    fun shouldReturnValueOfFiveInStraightAddedToValueOfStraighHandWhenLowStraight() {
        val handValue = HandEvaluator.evaluateStraight(lowStraightHand())
        assertThat(handValue, equalTo(FIVE_VALUE + Straight.value))

    }

    @Test
    fun shouldReturnValueOfAceInStraightAddedToValueOfStraightHandWhenHighStraight() {
        val handValue = HandEvaluator.evaluateStraight(highStraightHand())
        assertThat(handValue, equalTo(ACE_VALUE + Straight.value))
    }

    @Test
    fun shouldReturnHighestRankCardAddedToValueOfFlushHand() {
        val handValue = HandEvaluator.evaluateFlush(flushHand())
        assertThat(handValue, equalTo(JACK_VALUE + Flush.value))
    }

    @Test
    fun shouldReturnRankOfTripleAddedToValueOfFullHouseHand() {
        val handValue = HandEvaluator.evaluateFullHouse(fullHouseHand())
        assertThat(handValue, equalTo(TEN_VALUE + FullHouse.value))
    }

    @Test
    fun shouldReturnRankOfQuartetAddedToValueOfFourOfAKindHand() {
        val handValue = HandEvaluator.evaluateFourOfAKind(fourOfAKindHand())
        assertThat(handValue, equalTo(JACK_VALUE + FourOfAKind.value))
    }

    @Test
    fun shouldReturnRankOfTopCardAddedToValueOfStraightFlushHand() {
        val handValue = HandEvaluator.evaluateStraightFlush(straightFlushHand())
        assertThat(handValue, equalTo(EIGHT_VALUE + StraightFlush.value))
    }

    @Test
    fun shouldReturnValueOfRoyalFlushHandPlusOne() {
        val handValue = HandEvaluator.evaluateRoyalFlush()
        assertThat(handValue, equalTo(RoyalFlush.value + 1))
    }

    @Test
    fun shouldReturnRoyalFlushEnumWhenHandIsRoyalFlush(){
        val hand = royalFlushHand()
        val determinedHand:Hand = HandEvaluator.determineHand(hand)
        assertThat(determinedHand, equalTo(RoyalFlush))
    }

    @Test
    fun shouldReturnStraightFlushEnumWhenHandIsStraightFlush(){
        val hand = straightFlushHand()
        val determinedHand = HandEvaluator.determineHand(hand)
        assertThat(determinedHand, equalTo(StraightFlush))
    }

    @Test
    fun shouldReturnFourOfAKindEnumWhenHandIsFourOfAKind(){
        val hand = fourOfAKindHand()
        val determinedHand = HandEvaluator.determineHand(hand)
        assertThat(determinedHand, equalTo(FourOfAKind))

    }



    private fun royalFlushHand(): List<Card> {
        return listOf(Ace(Spade), King(Spade), Queen(Spade), Jack(Spade), Ten(Spade))

    }

    private fun straightFlushHand(): List<Card> {
        return listOf(Eight(Club), Seven(Club), Six(Club), Five(Club), Four(Club))

    }

    private fun fourOfAKindHand(): List<Card> {
        return listOf(Jack(Heart), Jack(Spade), Jack(Club), Jack(Diamond), Seven(Diamond))

    }

    private fun fullHouseHand(): List<Card> {
        return listOf(Ten(Heart), Ten(Diamond), Ten(Spade), Nine(Club), Nine(Diamond))

    }

    private fun flushHand(): List<Card> {
        return listOf(Four(Spade), Jack(Spade), Eight(Spade), Two(Spade), Nine(Spade))
    }

    private fun straightHand(): List<Card> {
        return listOf(Nine(Club), Eight(Diamond), Seven(Spade), Six(Diamond), Five(Heart))
    }

    private fun lowStraightHand(): List<Card> {
        return listOf(Five(Club), Four(Diamond), Three(Spade), Two(Diamond), Ace(Heart))
    }

    private fun highStraightHand(): List<Card> {
        return listOf(Ace(Club), King(Diamond), Queen(Spade), Jack(Diamond), Ten(Heart))
    }

    private fun threeOfAKindHand(): List<Card> {
        return listOf(Seven(Club), Seven(Diamond), Seven(Spade), King(Club), Three(Diamond))
    }

    private fun highestCardHand(): List<Card> {
        return listOf(Three(Diamond), Jack(Club), Eight(Spade), Four(Heart), Two(Spade))
    }

    private fun pairHand(): List<Card> {
        return listOf(Ace(Diamond), Ace(Heart), Eight(Club), Four(Spade), Seven(Heart))
    }

    private fun twoPairHand(): List<Card> {
        return listOf(Four(Club), Four(Spade), Three(Club), Three(Diamond), Queen(Spade))
    }


}