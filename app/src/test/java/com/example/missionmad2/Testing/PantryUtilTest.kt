package com.example.missionmad2.Testing

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PantryUtilTest {

    @Test
    fun `name added not the amount`() {

        val result = PantryUtil.validatePantryInput(
            "cupboard",
            ""
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `amounnt added not the name`(){
        val result=PantryUtil.validatePantryInput(
            "",
            "dsjfkdsjfhdskfsdf"
        )
        assertThat(result).isFalse()
    }
    @Test
    fun `both are added`(){
        val result=PantryUtil.validatePantryInput(
            "dskfjsfsd",
            "dfdsfdsfsd"
        )
        assertThat(result).isTrue()
    }
}
