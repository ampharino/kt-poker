import Suit.Spade
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CardPileTest {
    private var cardPile: CardPile? = null

    @BeforeEach
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
    internal fun drawStartingHandShouldRemoveAndReturnTwoCards() {

    }
}