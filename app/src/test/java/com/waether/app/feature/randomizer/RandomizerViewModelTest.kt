package com.waether.app.feature.randomizer

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Rule
import org.junit.Test



class RandomizerViewModelTest{


    // lines needed only if using LiveData
    @JvmField
    @Rule

    val instantExecutorRule = InstantTaskExecutorRule()
    @Test
    fun `init then update number liveData value to DEFAULT_VALUE`(){
        // initial value of numberLiveData is DEFAULT_VALUE  testing constructor of viewModel

        // Arrange
        //Act
        val viewModel = RandomizerViewModel()

        //Assert
        val result = viewModel.numberLiveData.value
        Assert.assertTrue(result == DEFAULT_VALUE)
    }
    @Test
    fun incrementNumberWhenNumberLiveDataValueIsZeroThenUpdateNumberLiveDataValueToOne(){
        // when I invoke incrementNumber() , numberLiveData is incremented by one

        // Arrange
        val viewModel = RandomizerViewModel()
        viewModel.numberLiveData.value = 0

        //Act
        viewModel.incrementNumber()

        //Assert
        val result = viewModel.numberLiveData.value
        Assert.assertTrue(result == 1)
    }

}