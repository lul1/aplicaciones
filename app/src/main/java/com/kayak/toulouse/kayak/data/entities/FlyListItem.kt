package com.kayak.toulouse.kayak.data.entities

data class FlyListItem(
        val origin: FlyListItemFly,
        val destination: FlyListItemFly,
        val price: Number,
        val airlines: String

)

