package com.example.testing.mock

import android.content.Context
import com.example.testing.R
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UriValidatorTest {

    private val NOTHING = "Nothing"
    private val URL = "URL"
    private val FILE = "File"

    lateinit var uriValidator: UriValidator
    lateinit var mockContext: Context

    @Before
    fun setUp() {
        mockContext = Mockito.mock(Context::class.java)
        Mockito.`when`(mockContext.getString(R.string.nothing)).thenReturn(NOTHING)
        Mockito.`when`(mockContext.getString(R.string.url)).thenReturn(URL)
        Mockito.`when`(mockContext.getString(R.string.file)).thenReturn(FILE)
        uriValidator = UriValidator(mockContext)
    }


    @Test
    fun validate() {
        assertThat(uriValidator.validate("http://google.com"), `is`(URL))
        assertThat(uriValidator.validate("file://sdcard/DCIM/img001.jpg"), `is`(FILE))
        assertThat(uriValidator.validate("bla-bla-bla"), `is`(NOTHING))
    }


    @After
    fun tearDown() {
    }

}