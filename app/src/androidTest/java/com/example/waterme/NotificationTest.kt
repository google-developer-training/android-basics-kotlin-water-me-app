/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.waterme

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NotificationTest {

    private val timeout: Long = 6000

    private val plantName = "Carrot"

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var uiDevice: UiDevice

    @Before
    fun setup() {
        uiDevice = UiDevice.getInstance(getInstrumentation())
        onView(withText("Carrot")).perform(longClick())
        onView(withText("5 seconds")).perform(click())
        uiDevice.pressHome()
        uiDevice.openNotification()
        uiDevice.wait(Until.hasObject(By.textContains(plantName)), timeout)
    }

    @Test
    fun notification_scheduled() {
        val notification = uiDevice.findObject(UiSelector().textContains(plantName)).exists()
        assertTrue("Could not find text 'Carrot'", notification)
        uiDevice.pressHome()
    }

    @Test
    fun notification_click() {
        val notification = uiDevice.findObject(UiSelector().textContains("Carrot"))
        notification.click()
        uiDevice.wait(Until.hasObject(By.pkg("com.example.waterme")
            .depth(0)), 1000)
        val pkg = uiDevice.findObject(UiSelector().packageName("com.example.waterme"))
            .exists()
        assertTrue("Could not find package", pkg)
    }
}
