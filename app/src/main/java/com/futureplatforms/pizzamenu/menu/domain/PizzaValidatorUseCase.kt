package com.futureplatforms.pizzamenu.menu.domain

import com.futureplatforms.pizzamenu.menu.data.Pizza
import com.futureplatforms.pizzamenu.menu.data.Topping

class PizzaValidatorUseCase {

    fun execute(pizza: Pizza): Boolean = pizza.name.isNotEmpty()
            && pizza.toppings.size >= 2
            && pizza.toppings.contains(Topping("Tomato sauce", true, emptyList())
    )
}