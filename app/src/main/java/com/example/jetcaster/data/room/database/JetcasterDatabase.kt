/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetcaster.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetcaster.data.room.entity.Category
import com.example.jetcaster.data.room.entity.Episode
import com.example.jetcaster.data.room.entity.Podcast
import com.example.jetcaster.data.room.entity.PodcastCategoryEntry
import com.example.jetcaster.data.room.entity.PodcastFollowedEntry
import com.example.jetcaster.data.room.DateTimeTypeConverters
import com.example.jetcaster.data.room.dao.CategoriesDao
import com.example.jetcaster.data.room.dao.EpisodesDao
import com.example.jetcaster.data.room.dao.PodcastCategoryEntryDao
import com.example.jetcaster.data.room.dao.PodcastFollowedEntryDao
import com.example.jetcaster.data.room.dao.PodcastsDao
import com.example.jetcaster.data.room.dao.TransactionRunnerDao

/**
 * The [RoomDatabase] we use in this app.
 */
@Database(
    entities = [
        Podcast::class,
        Episode::class,
        PodcastCategoryEntry::class,
        Category::class,
        PodcastFollowedEntry::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateTimeTypeConverters::class)
abstract class JetcasterDatabase : RoomDatabase() {
    abstract fun podcastsDao(): PodcastsDao
    abstract fun episodesDao(): EpisodesDao
    abstract fun categoriesDao(): CategoriesDao
    abstract fun podcastCategoryEntryDao(): PodcastCategoryEntryDao
    abstract fun transactionRunnerDao(): TransactionRunnerDao
    abstract fun podcastFollowedEntryDao(): PodcastFollowedEntryDao
}
