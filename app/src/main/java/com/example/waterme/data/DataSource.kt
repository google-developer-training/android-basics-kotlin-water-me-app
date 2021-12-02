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
package com.example.waterme.data

import com.example.waterme.model.Plant

object DataSource {
   val plants = listOf(
       Plant(
           name = "Lithop",
           schedule = "monthly",
           type = "Succulent",
           description = "Stone mimicking succulent"
       ),
       Plant(
           name = "Carrot",
           schedule = "daily",
           type = "Root",
           description = "Hardy root vegetable"
       ),
       Plant(
           name = "Peony",
           schedule = "weekly",
           type = "Flower",
           description = "Spring blooming flower"
       ),
       Plant(
           name = "Pothos",
           schedule = "weekly",
           type = "Houseplant",
           description = "Indoor vine"
       ),
       Plant(
           name = "Fiddle Leaf Fig",
           schedule = "weekly",
           type = "Broadleaf evergreen",
           description = "Ornamental fig"
       ),
       Plant(
           name = "Strawberry",
           schedule = "daily",
           type = "Fruit",
           description = "Delicious 'multiple fruit'"
       )
   )
}
