package io.github.rcscreenbuilder

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.*

val jsonParser = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true }

class AppBuilder{

    private lateinit var metaData : AppMetaData

    companion object{
        fun initialize(jsonContents: String) : AppBuilder? {

            try {
                val appBuilder = AppBuilder()
                appBuilder.metaData = jsonParser.decodeFromString(jsonContents)
                return appBuilder
            } catch (error : Exception) {
                print(error)
            }
            return null

        }
    }

    fun getFeatures() : List<FeatureItem> {
        return metaData.features
    }

    fun screen(id: String) : ScreenBuilder? {

        val screenData = metaData.screens.get(id)

        if (screenData != null) {
            return ScreenBuilder.Companion.initialize(screenData)
        }

        return null
    }

}

class ScreenBuilder {

    companion object {
        fun initialize(jsonArray: JsonArray) : ScreenBuilder? {
            val screenBuilder = ScreenBuilder()
            screenBuilder.initialize(jsonArray)
            return if (screenBuilder.inputItems.isEmpty()) null else screenBuilder
        }
        fun initialize(jsonContents: String) : ScreenBuilder? {
            val screenBuilder = ScreenBuilder()
            screenBuilder.initialize(jsonContents)
            return if (screenBuilder.inputItems.isEmpty()) null else screenBuilder
        }

    }

    var inputItems : List<InputItem<*>> = ArrayList()

    fun initialize(jsonArray: JsonArray) : ScreenBuilder {
        try {

            val targetItems : ArrayList<InputItem<*>> = ArrayList()

            for (item in jsonArray) {

                when (item.jsonObject["type"]?.jsonPrimitive?.content) {
                    InputType.Text.toString() -> {

                        when (item.jsonObject["keyboardType"]?.jsonPrimitive?.content) {
                            KeyboardType.Text.toString() -> {
                                val inputItem : TextInputItem = jsonParser.decodeFromJsonElement(item)
                                targetItems.add(inputItem)
                            }
                            KeyboardType.Number.toString() -> {
                                val inputItem : NumberInputItem = jsonParser.decodeFromJsonElement(item)
                                targetItems.add(inputItem)
                            }
                            KeyboardType.Decimal.toString() -> {
                                val inputItem : DecimalInputItem = jsonParser.decodeFromJsonElement(item)
                                targetItems.add(inputItem)
                            }
                        }

                    }
                    InputType.DropDown.toString() -> {
                        val inputItem : DropDownInputItem = jsonParser.decodeFromJsonElement(item)
                        targetItems.add(inputItem)
                    }
                    InputType.Checkbox.toString() -> {
                        val inputItem : CheckboxInputItem = jsonParser.decodeFromJsonElement(item)
                        targetItems.add(inputItem)
                    }
                }
            }

            inputItems = targetItems

        } catch (error : Exception) {
            print(error)
        }

        return this
    }

    fun initialize(jsonContents: String) : ScreenBuilder{
        try {
            val jsonArray: JsonArray = jsonParser.decodeFromString(jsonContents)
            return initialize(jsonArray)
        } catch (error : Exception) {
            print(error)
        }

        return this
    }

    fun validateInput() : Boolean {

        var isValid = true

        if (inputItems.isNotEmpty()) {
            for (item in inputItems) {

                when (item.type) {
                    InputType.Text -> {

                        when (item) {
                            is TextInputItem -> {
                                val regexValue = item.regex
                                if (regexValue != null) {
                                    val value = item.userValue
                                    val regex = Regex(regexValue)
                                    if (value == null || !regex.containsMatchIn(value)) {
                                        isValid = false
                                        break
                                    }
                                }
                            }
                            is NumberInputItem -> {
                                val regexValue = item.regex
                                if (regexValue != null) {
                                    val value = item.userValue
                                    val regex = Regex(regexValue)
                                    if (value == null || !regex.containsMatchIn(value.toString())) {
                                        isValid = false
                                        break
                                    }
                                }
                            }
                            is DecimalInputItem -> {
                                val regexValue = item.regex
                                if (regexValue != null) {
                                    val value = item.userValue
                                    val regex = Regex(regexValue)
                                    if (value == null || !regex.containsMatchIn(value.toString())) {
                                        isValid = false
                                        break
                                    }
                                }
                            }

                        }

                    }
                    InputType.Checkbox -> {
                        val inputItem = item as CheckboxInputItem
                        if (inputItem.validValue != null) {
                            val value = item.userValue
                            if (value == null || value != item.validValue) {
                                isValid = false
                                break
                            }
                        }
                    }
                    InputType.DropDown -> {
                        val inputItem = item as DropDownInputItem
                        if (inputItem.isMandatory) {
                            val value = item.userValue
                            if (value == null) {
                                isValid = false
                                break
                            }
                        }
                    }
                }
            }
        }

        return isValid
    }

    fun inputDataMapping() : Map<String,Any> {
        val hashMap : HashMap<String, Any> = HashMap()
        if (inputItems.isNotEmpty()) {
            for (item in inputItems) {
                val userValue = item.userValue
                if (userValue != null) {
                    hashMap[item.keyName] = userValue
                }
            }
        }
        return hashMap
    }

}
