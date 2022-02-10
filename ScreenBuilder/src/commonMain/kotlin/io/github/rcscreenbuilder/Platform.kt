package io.github.rcscreenbuilder

expect class Platform() {
    val platform: String
}

expect fun randomUUID(): String