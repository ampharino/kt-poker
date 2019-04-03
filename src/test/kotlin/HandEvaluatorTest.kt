import Card.*
import Hand.*
import Suit.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

private val JACK_VALUE = 10
private val ACE_VALUE = 13
private val FOUR_VALUE = 3
private val SEVEN_VALUE = 6

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