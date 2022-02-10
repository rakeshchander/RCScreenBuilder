package io.github.rcscreenbuilder

import kotlinx.serialization.Serializable

@Serializable
enum class InputType {
    Text,
    DropDown,
    Checkbox
}

@Serializable
enum class KeyboardType {
    Phone,
    Email,
    Text,
    Number,
    Decimal
}

interface InputItem<T> {
    val hashId: String
    get() = randomUUID()
    var userValue: T?
    val type: InputType
    var title: String
    var keyName: String
}

@Serializable
data class TextInputItem(
    override val type: InputType = InputType.Text,
    override var userValue: String? = null,
    override var title: String,
    override var keyName: String,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val regex: String? = null,
    val unit: String? = null
) : InputItem<String>

@Serializable
data class NumberInputItem(
    override val type: InputType = InputType.Text,
    override var userValue: Int? = null,
    override var title: String,
    override var keyName: String,
    val keyboardType: KeyboardType = KeyboardType.Number,
    val regex: String? = null,
    val unit: String? = null
) : InputItem<Int>

@Serializable
data class DecimalInputItem(
    override val type: InputType = InputType.Text,
    override var userValue: Float? = null,
    override var title: String,
    override var keyName: String,
    val keyboardType: KeyboardType = KeyboardType.Decimal,
    val regex: String? = null,
    val unit: String? = null
) : InputItem<Float>

@Serializable
data class CheckboxInputItem(
    override val type: InputType = InputType.Checkbox,
    override var userValue: Boolean? = false,
    override var title: String,
    override var keyName: String,
    val validValue: Boolean? = null
) : InputItem<Boolean>

@Serializable
data class DropDownInputItem(
    override val type: InputType = InputType.DropDown,
    override var userValue: Int? = null,
    override var title: String,
    override var keyName: String,
    val isMandatory: Boolean = false,
    val options: List<DropDownItem>
) : InputItem<Int>

@Serializable
data class DropDownItem(
    val displayValue: String,
    val hashId: Int
)