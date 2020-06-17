package room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entry(
    val title: String?,
    val description: String?,
    val imagePath: String?
){
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}