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
package com.example.waterme.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.waterme.R
import com.example.waterme.viewmodel.PlantViewModel
import com.example.waterme.viewmodel.PlantViewModelFactory
import java.util.concurrent.TimeUnit

class ReminderDialogFragment(private val plantName: String) : DialogFragment() {

    private val viewModel: PlantViewModel by viewModels {
        PlantViewModelFactory(requireActivity().application)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
                .setTitle(R.string.water_reminder)
                .setItems(R.array.water_schedule_array) { _, position ->
                    when (position) {
                        0 ->
                            viewModel
                                .scheduleReminder(5, TimeUnit.SECONDS, plantName)
                        1 ->
                            viewModel
                                .scheduleReminder(1, TimeUnit.DAYS, plantName)
                        2 ->
                            viewModel
                                .scheduleReminder(7, TimeUnit.DAYS, plantName)
                        3 ->
                            viewModel
                                .scheduleReminder(30, TimeUnit.DAYS, plantName)
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
