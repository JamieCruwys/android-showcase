package uk.co.jamiecruwys.gratitude.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JournalEntryModule {
    @Singleton
    @Provides
    fun journalEntryDatabase(
        @ApplicationContext appContext: Context,
    ): JournalEntryDatabase =
        Room.databaseBuilder(
            context = appContext,
            klass = JournalEntryDatabase::class.java,
            name = JournalEntryDatabase.NAME,
        ).build()

    @Provides
    fun provideJournalEntryDao(database: JournalEntryDatabase): JournalEntryDao = database.journalEntryDao()
}
