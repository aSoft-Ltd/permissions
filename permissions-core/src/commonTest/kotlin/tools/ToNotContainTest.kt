package tools

import tz.co.asoft.expect
import tz.co.asoft.toNotContain
import kotlin.test.Test
import kotlin.test.assertFails

class ToNotContainTest {
    @Test
    fun should_pass_when_there_is_no_element_in_the_collection() {
        expect(listOf(1, 2, 3)).toNotContain(4)
    }

    @Test
    fun should_fail_where_there_is_an_element_in_the_collection() {
        assertFails {
            expect(listOf(1, 2, 3)).toNotContain(2)
        }
    }
}