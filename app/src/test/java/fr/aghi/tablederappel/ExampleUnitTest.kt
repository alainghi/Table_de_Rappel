package fr.aghi.tablederappel

import org.junit.Test
import org.junit.Assert.*
import fr.aghi.tablederappel.model.Item
import fr.aghi.tablederappel.model.TBNombreItem

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun item_creation_isCorrect() {
        val item = Item("CHAT", "6")
        assertEquals("CHAT", item.mot)
        assertEquals("6", item.numero)
    }

    @Test
    fun tbNombreItem_creation_isCorrect() {
        val item = TBNombreItem("6", "CHAT", "image6.png")
        assertEquals("6", item.numero)
        assertEquals("CHAT", item.mot)
        assertEquals("image6.png", item.image)
    }
}