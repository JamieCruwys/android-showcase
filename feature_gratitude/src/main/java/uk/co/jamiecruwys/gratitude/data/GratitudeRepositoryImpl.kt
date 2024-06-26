package uk.co.jamiecruwys.gratitude.data

import uk.co.jamiecruwys.gratitude.data.database.JournalEntryDao
import uk.co.jamiecruwys.gratitude.presentation.domain.model.GratitudeEntry
import uk.co.jamiecruwys.gratitude.presentation.domain.toGratitudeEntry
import uk.co.jamiecruwys.gratitude.presentation.domain.toJournalEntry
import javax.inject.Inject

class GratitudeRepositoryImpl
    @Inject
    constructor(private val journalEntryDao: JournalEntryDao) : GratitudeRepository {
        override suspend fun getEntries(): List<GratitudeEntry> {
            val dbEntries = journalEntryDao.getAll()
            val domainEntries = dbEntries.map { it.toGratitudeEntry() }
            return domainEntries.sortedByDescending { it.created.time }
        }

        override suspend fun addEntry(gratitudeEntry: GratitudeEntry): List<GratitudeEntry> {
            val dbEntry = gratitudeEntry.toJournalEntry()
            journalEntryDao.add(dbEntry)
            return getEntries()
        }
    }
