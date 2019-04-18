import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

internal class GameTest{

    @Test
    internal fun gameShouldInitializeWith48CardsAndTwoPlayers(){
        val deck = CardPile()
        val player1 = Player("John", deck, 100)
        val player2 = Player("Jack", deck, 100)
        val gameSession = Game(deck, player1, player2 )
        assertThat(gameSession.cards.size(), equalTo(48))
        assertThat(gameSession.players.size, equalTo(2))
    }

}