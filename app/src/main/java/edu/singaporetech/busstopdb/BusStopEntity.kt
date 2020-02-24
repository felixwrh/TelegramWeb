package edu.singaporetech.busstopdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bus_station_table")
data class BusStopEntity(val bus_stop_code : String, val road_name : String, val bus_stop_description : String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}