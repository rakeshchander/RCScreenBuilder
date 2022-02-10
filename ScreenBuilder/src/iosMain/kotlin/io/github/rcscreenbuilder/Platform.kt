package io.github.rcscreenbuilder

import platform.Foundation.NSUUID
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun randomUUID(): String = NSUUID().UUIDString()