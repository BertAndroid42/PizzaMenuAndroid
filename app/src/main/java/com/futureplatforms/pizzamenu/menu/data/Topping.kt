package com.futureplatforms.pizzamenu.menu.data

data class Topping(
    val name: String,
    val isVegan: Boolean,
    val allergens: List<String>
)
