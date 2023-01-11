package com.futureplatforms.pizzamenu.menu.data

data class Pizza(
    val name: String,
    val base: Base,
    val toppings: List<Topping>
)
