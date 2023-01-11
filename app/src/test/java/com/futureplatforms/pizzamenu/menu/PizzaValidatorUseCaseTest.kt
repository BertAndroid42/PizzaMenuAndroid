package com.futureplatforms.pizzamenu.menu

import com.futureplatforms.pizzamenu.menu.data.Base
import com.futureplatforms.pizzamenu.menu.data.Pizza
import com.futureplatforms.pizzamenu.menu.data.Topping
import com.futureplatforms.pizzamenu.menu.domain.PizzaValidatorUseCase
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class PizzaValidatorUseCaseTest {

    // Example bases
    private val thinAndCrispyBase = Base("Thin and Crispy", true, listOf("Gluten"))
    private val pepperoniStuffedCrust = Base("Pepperoni Stuffed Crust", false, listOf("Mustard", "Gluten"))

    // Example toppings
    private val tomatoSauce = Topping("Tomato sauce", true, emptyList())
    private val bbqSauce = Topping("Barbecue sauce", true, listOf("Mustard"))
    private val mozzarella = Topping("Mozzarella", false, listOf("Milk"))
    private val mushroom = Topping("Mushrooms", true, emptyList())
    private val pepperoni = Topping("Pepperoni", false, listOf("Gluten", "Mustard"))

    @Test
    fun `Given a Tomato pizza Then Validate false`() {
        // Given
        val pizza = Pizza("Tomato pizza", thinAndCrispyBase, mutableListOf<Topping>().apply {
            add(tomatoSauce)
        })
        // When
        val result = PizzaValidatorUseCase().execute(pizza)
        // Then
        assertFalse(result)
    }

    @Test
    fun `Given a pizza without Tomato Then Validate false`() {
        // Given
        val pizza = Pizza("Tomato pizza", thinAndCrispyBase, mutableListOf<Topping>().apply {
            add(mozzarella)
        })
        // When
        val result = PizzaValidatorUseCase().execute(pizza)
        // Then
        assertFalse(result)
    }

    @Test
    fun `Given a Margherita pizza Then Validate true`() {
        // Given
        val pizza = Pizza("Margherita pizza", thinAndCrispyBase, mutableListOf<Topping>().apply {
            add(tomatoSauce)
            add(mozzarella)
        })
        // When
        val result = PizzaValidatorUseCase().execute(pizza)
        // Then
        assertTrue(result)
    }
}
