package tz.co.asoft

/**
 * Adds a claim to a list of claims
 * @return
 *
 * false - when the list of claims already have the [claim], or the list has a "*"
 *
 * true - when the above conditions are not met and the claim is successfully added to the list
 */
fun MutableList<String>.addClaim(claim: String): Boolean {
    return if (contains("*") || contains(claim)) false
    else add(claim)
}