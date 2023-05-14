package com.example.missionmad2.Testing


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class IngredientUtilTest {

    @Test
    fun `empty ingname and added amount`() {
        val result = IngredientUtil.validateIngredients(
            "",
            "56kg"
        )
        assertThat(result).isFalse()
    }
      @Test
     fun `empty amount  and added ingname` (){
         val result=IngredientUtil.validateIngredients(
             "sdhfjshgjf",
             ""
         )
          assertThat(result).isFalse()
     }


    @Test
    fun `amount and name added` (){
        val result=IngredientUtil.validateIngredients(
            "sdhfjshgjf",
            "fdgfdgdfgf"
        )
        assertThat(result).isTrue()
    }


}




