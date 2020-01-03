package com.thengoding.cuacaku

import com.thengoding.cuacaku.utils.dateToName
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals("Kamis, 2 Januari 2020", dateToName())
    }
}
