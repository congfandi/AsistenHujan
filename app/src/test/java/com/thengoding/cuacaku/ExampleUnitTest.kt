package com.thengoding.cuacaku

import com.thengoding.cuacaku.extentions.dateToName
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
        assertEquals("Minggu, 29 Desember 2019", dateToName("2019-12-29"))
    }
}
