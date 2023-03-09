package com.isansc.genericadapterpoc.model

open class PacingConfig(
    val item: EdgeItem,
    val start: Int,
    val pacing: Int,
    val occurrences: Int = INFINITE
) {
    companion object {
        const val INFINITE = -1
    }
}