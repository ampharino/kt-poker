import Card.*
import Hand.*
import Suit.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

private val JACK_VALUE = 10
private val ACE_VALUE = 13
private val FOUR_VALUE = 3

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

    private fun highestCardHand(): List<Card> {
        return listOf(Three(Diamond), Jack(Club), Eight(Spade), Four(Heart), Two(Spade))
    }

    private fun pairHand(): List<Card> {
        return listOf(Ace(Diamond), Ace(Heart), Eight(Club), Four(Spade), Seven(Heart))
    }

    private fun twoPairHand(): List<Card>{
        return listOf(Four(Club), Four(Spade), Three(Club), Three(Diamond), Queen(Spade))
    }


}