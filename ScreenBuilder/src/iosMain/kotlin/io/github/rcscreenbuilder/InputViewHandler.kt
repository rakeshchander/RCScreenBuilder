package io.github.rcscreenbuilder

import platform.UIKit.UITextField
import platform.UIKit.UIView

actual typealias ViewLayer = UIView

internal actual fun getScreenContents(inputItems : List<InputItem<*>>) : ViewLayer {

    UITextField()

    return ViewLayer()
}