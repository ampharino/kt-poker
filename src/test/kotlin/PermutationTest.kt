import Card.*
import Suit.Spade
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

const val SEVEN_CHOOSE_FIVE = 21

internal class PermutationTest {
    @Test
    fun shouldGenerate21PermutationsWhenChoosing5CardsFromSeven() {
        val permutations = listOf(
            Ace(Spade),
            Two(Spade), Three(Spade), Four(Spade), Five(Spade),
            Six(Spade), Seven(Spade)
        ).generatePermutations(result = ArrayList(), size = 5)
        assertThat(permutations.size, equalTo(SEVEN_CHOOSE_FIVE))

    }
}