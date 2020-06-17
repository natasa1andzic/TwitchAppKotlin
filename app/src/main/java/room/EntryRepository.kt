package room

import androidx.lifecycle.LiveData

class EntryRepository(private val entryDAO: EntryDAO) {

    val entries : LiveData<List<Entry>> = entryDAO.getAll()

    suspend fun insert(entry: Entry) {
        entryDAO.insert(entry)
    }
}