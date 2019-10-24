package com.vama.hidoc

import android.content.Context


import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Test

import org.junit.Assert.assertEquals

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */

class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        assertEquals("com.vama.hidoc", appContext.packageName)
    }
}
