package room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EntryDAO {

    @Query("SELECT * FROM entry")
    fun getAll(): LiveData<List<Entry>>

    @Query("SELECT * FROM entry WHERE uid IN (:entryIds)")
    fun loadAllByIds(entryIds: IntArray): LiveData<List<Entry>>

    @Query(
        "SELECT * FROM entry WHERE title LIKE '%' || :title || '%' LIMIT 1"
    )
    fun findByTitle(title: String): LiveData<Entry>

    @Insert
    fun insert(entry: Entry)

    @Update
    fun updateEntry(entry: Entry)

    @Delete
    fun delete(entry: Entry)

}