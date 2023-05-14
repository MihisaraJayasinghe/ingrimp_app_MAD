package com.example.missionmad2.Testing


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RecipeUtilTest{

    @Test
    fun `recipe name added and ingredeints and instructions not added`(){

        val reciperesult=RecipeUtil.validateRecipeInput(
            "watalappan",
            "",
            ""
        )

        assertThat(reciperesult).isFalse()
    }

    @Test
    fun `recipe ingredeints added and name and instructions not added`(){

        val reciperesult=RecipeUtil.validateRecipeInput(
            "",
            "eggs" +
                    "milk" +
                    "bread",
            ""
        )

        assertThat(reciperesult).isFalse()
    }

    @Test
    fun `recipe name and ingredeints not addes instructions added`(){

        val reciperesult=RecipeUtil.validateRecipeInput(
            "",
            "",
            "its easy to make"
        )

        assertThat(reciperesult).isFalse()
    }

}