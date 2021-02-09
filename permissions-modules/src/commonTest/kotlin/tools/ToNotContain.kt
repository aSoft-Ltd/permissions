@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import kotlin.test.assertTrue

fun <T> Expectation<Collection<T>>.toNotContain(vararg elements: T) {
    assertTrue(
        """
    
    Expected   : ${elements.joinToString(",", prefix = "[", postfix = "]") { it.toString() }} to not be inside the collection
    Collection : [
        ${value.joinToString(separator = "\n        ") { it.toString() }}
    ]
    ===============================================
""".trimIndent()
    ) { !value.containsAll(elements.toList()) }
}