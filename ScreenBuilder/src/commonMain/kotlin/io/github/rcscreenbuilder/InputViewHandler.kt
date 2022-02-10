package io.github.rcscreenbuilder


expect class ViewLayer

internal expect fun getScreenContents(inputItems : List<InputItem<*>>) : ViewLayer
