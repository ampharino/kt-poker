import Suit.Heart
import Suit.Spade
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Before
import org.junit.Test

internal class CardPileTest {
    private var cardPile: CardPile? = null

    @Before
    internal fun setUp() {
        cardPile = CardPile()
    }


    @Test
    internal fun shouldHave52Cards() {
        assertThat(cardPile!!.size(), equalTo(52))
    }

    @Test
    internal fun shouldHave13SpadeCards() {
        val spadeCards = cardPile!!.cards.filter { card -> card.suit == Spade }
        assertThat(spadeCards.size, equalTo(13))
    }

    @Test
    fun shouldHave13HeartCards() {
        val heartCards = cardPile!!.cards.filter { card -> card.suit == Heart }
        assertThat(heartCards.size, equalTo(13))
    }

    @Test
    fun shouldHaveCorrectCardsInSuit(){
        val spadeCards = cardPile!!.cards.filter { card -> card.suit == Spade }

        val aces = spadeCards.filter { card -> card is Card.Ace }
        val twos = spadeCards.filter { card -> card is Card.Two }
        val threes = spadeCards.filter { card -> card is Card.Three }
        val fours = spadeCards.filter { card -> card is Card.Four }
        val fives = spadeCards.filter { card -> card is Card.Five }
        val sixes = spadeCards.filter { card -> card is Card.Six }
        val sevens = spadeCards.filter { card -> card is Card.Seven }
        val eights = spadeCards.filter { card -> card is Card.Eight }
        val nines = spadeCards.filter { card -> card is Card.Nine }
        val tens = spadeCards.filter { card -> card is Card.Ten }
        val jacks = spadeCards.filter { card -> card is Card.Jack }
        val queens = spadeCards.filter { card -> card is Card.Queen }
        val kings = spadeCards.filter { card -> card is Card.King }

        assertThat(aces.size, equalTo(1))
        assertThat(twos.size, equalTo(1))
        assertThat(threes.size, equalTo(1))
        assertThat(fours.size, equalTo(1))
        assertThat(fives.size, equalTo(1))
        assertThat(sixes.size, equalTo(1))
        assertThat(sevens.size, equalTo(1))
        assertThat(eights.size, equalTo(1))
        assertThat(nines.size, equalTo(1))
        assertThat(tens.size, equalTo(1))
        assertThat(jacks.size, equalTo(1))
        assertThat(queens.size, equalTo(1))
        assertThat(kings.size, equalTo(1))
    }

    @Test
    internal fun drawStartingHandShouldRemoveAndReturnTwoCards() {
        val startingCards = cardPile!!.drawStartingHand()
        assertThat(startingCards.size, equalTo(2))
        assertThat(cardPile!!.size(), equalTo(50))
    }

    @Test
    fun drawCardShouldRemoveAndReturnACard() {
        val card = cardPile!!.drawCard()
        assertThat(card.size, equalTo(1))
        assertThat(cardPile!!.size(), equalTo(51))

    }
}