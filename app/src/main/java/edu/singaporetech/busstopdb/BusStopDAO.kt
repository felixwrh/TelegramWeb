package edu.singaporetech.busstopdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface BusStopDAO {
    @Query("select * from bus_station_table")
    fun getAll(): LiveData<List<BusStopEntity>>

    // Don't use for production env!
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(busStopEntity: BusStopEntity)
}