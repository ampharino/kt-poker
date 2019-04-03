import Card.*
import Suit.*
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

private val JACK_VALUE = 11

internal class HandEvaluatorTest {
    @Test
    fun shouldReturnValueOfHighestCardForHighCardHand() {
        val handValue = HandEvaluator.evaluateHighestCard(HighestCardHand())
        assertThat(handValue, equalTo(JACK_VALUE))
    }



    fun HighestCardHand(): List<Card> {
        return listOf(Three(Diamond), Jack(Club), Eight(Spade), Four(Heart), Two(Spade))
    }


}