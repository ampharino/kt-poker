import Card.*
import Hand.*
import Suit.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

private val JACK_VALUE = 11
private val ACE_VALUE = 1

internal class HandEvaluatorTest {
    @Test
    fun shouldReturnValueOfHighestCardForHighCardHand() {
        val handValue = HandEvaluator.evaluateHighestCard(highestCardHand())
        assertThat(handValue, equalTo(JACK_VALUE))
    }

    @Test
    fun shouldReturnValueOfCardInPairAddedToValueOfPair() {
        val handValue = HandEvaluator.evaluatePair(pairHand())
        assertThat(handValue, equalTo(Pair.value + ACE_VALUE))
    }

    private fun highestCardHand(): List<Card> {
        return listOf(Three(Diamond), Jack(Club), Eight(Spade), Four(Heart), Two(Spade))
    }

    private fun pairHand(): List<Card> {
        return listOf(Ace(Diamond), Ace(Heart), Eight(Club), Four(Spade), Seven(Heart))
    }


}