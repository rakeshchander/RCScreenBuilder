package io.github.rcscreenbuilder

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}