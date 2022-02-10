package io.github.rcscreenbuilder

import android.view.View


actual typealias ViewLayer = View

internal actual fun getScreenContents(inputItems : List<InputItem<*>>) : ViewLayer {



    return ViewLayer(null)
}
