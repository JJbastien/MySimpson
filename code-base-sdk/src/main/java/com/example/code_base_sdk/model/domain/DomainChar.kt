package com.example.code_base_sdk.model.domain

import android.content.Context
import com.example.code_base_sdk.model.RelatedTopic
import com.example.code_base_sdk.utils.IMAGE_URL
import java.util.regex.Pattern

data class DomainChar(
    val name: String,
    val description: String,
    val color: Int,
    val imageUrl: String? = null
)

fun List<RelatedTopic>?.mapToDomain(): List<DomainChar> {
    var counter = 0
    return this?.map {
        if (counter <= 6)  {
            counter++
        } else {
            counter = 1
        }

        DomainChar(
            name = it.text.getCharacterName(),
            description = it.text ?: "No description",
            imageUrl = it.icon?.uRL?.run { "$IMAGE_URL${this}" },
            color = counter
        )
    } ?: emptyList()
}

fun String?.getCharacterName(): String {
    this?.let {
        var characterName = ""
        val pattern = Pattern.compile("<.*?>(.*?)</a>")
        val matcher = pattern.matcher(this)
        characterName = if(matcher.find()) {
            matcher.group(1)
        } else {
            this
        }

        return characterName
    } ?: return "Invalid name"
}
