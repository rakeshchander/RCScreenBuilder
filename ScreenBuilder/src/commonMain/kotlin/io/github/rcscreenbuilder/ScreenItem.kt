package io.github.rcscreenbuilder

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class AppMetaData(
    val features : List<FeatureItem>,
    val screens: Map<String, JsonArray>
)

@Serializable
data class FeatureItem (
    val id: String,
    val title: String,
    val target: String,
    val screen: String
)