import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

internal class PlayerTest {
    private var player:Player? = null

    @Before
    internal fun setUp() {
        val cardPile = mock(CardPile::class.java)
        player = Player(name = "John", drawPile = cardPile)
    }

    @Test
    internal fun shouldCreatePlayerWithJohnAsName() {
        assertThat(player!!.name, equalTo("John"))
    }


    @Test
    internal fun playerShouldStartNewRoundWithTwoCards(){
        assertThat(player!!.cards.size, equalTo(2))
    }

    @Test
    internal fun shouldDrawCardsFromPileForStartingHand(){
        verify(player!!.drawPile).drawStartingHand()
    }
}

