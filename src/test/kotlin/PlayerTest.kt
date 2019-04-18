import Card.*
import Suit.Spade
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

internal class PlayerTest {
    private var player: Player? = null

    @Before
    internal fun setUp() {
        val cardPile = mock(CardPile::class.java)
        `when`(cardPile.drawStartingHand()).thenReturn(listOf(King(Spade), Queen(Spade)))
        player = Player(name = "John", drawPile = cardPile, balance = 100)
    }

    @Test
    internal fun shouldCreatePlayerWithJohnAsName() {
        assertThat(player!!.name, equalTo("John"))
    }


    @Test
    internal fun playerShouldStartNewRoundWithTwoCards() {
        assertThat(player!!.cards.size, equalTo(2))
    }

    @Test
    internal fun shouldDrawCardsFromPileForStartingHand() {
        verify(player!!.drawPile).drawStartingHand()
    }

    @Test
    internal fun raisingShouldDeductFromPlayerBalanceAndIncreasePot() {
        var pot = 0
        pot += player!!.raise(50)
        assertThat(pot, equalTo(50))
        assertThat(player!!.balance, equalTo(50))
    }
}

