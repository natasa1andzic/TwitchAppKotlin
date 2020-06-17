package room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Entry(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val title: String?,
    val description: String?,
    val imagePath: String?
)