package edu.singaporetech.busstopdb

import androidx.lifecycle.LiveData


class BusStopRepository (private val busStopDAO: BusStopDAO) {

    var allBusStops: LiveData<List<BusStopEntity>>

    init {
        allBusStops = busStopDAO.getAll()
    }

    suspend fun insert(busStopEntity: BusStopEntity) {
        busStopDAO.insert(busStopEntity)
    }
}