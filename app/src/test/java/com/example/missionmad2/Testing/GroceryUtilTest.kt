package com.example.missionmad2.Testing

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GroceryUtilTest{

    @Test
    fun `name added not the amount`(){

        val result=GroceryUtil.validateGroceryInputs(
            "rice",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `amount added not the name`(){

        val result=GroceryUtil.validateGroceryInputs(
            "",
            "56kg"
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `name added and the amount`(){

        val result=GroceryUtil.validateGroceryInputs(
            "milkrice",
            "78kg"
        )
        assertThat(result).isTrue()
    }
}