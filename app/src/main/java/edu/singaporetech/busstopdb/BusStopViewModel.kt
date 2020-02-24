package edu.singaporetech.busstopdb

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class BusStopViewModel(context : Context) : ViewModel() {
    private var repository: BusStopRepository

    val TAG:String = "FourDigitViewModel"
    lateinit var busStopList: LiveData<List<BusStopEntity>>
    init {
        Log.i(TAG, "FourDigitViewModel created!")
        val fourDigitDao = AppRoomDatabase.getDatabase(context, viewModelScope).stationDAO()
        repository = BusStopRepository(fourDigitDao)
        busStopList = repository.allBusStops
    }

    fun add(busStopEntity: BusStopEntity) = viewModelScope.launch {
        // We need to add the data into Room
        repository.insert(busStopEntity)
    }
}



class BusStopViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusStopViewModel::class.java)) {
            return BusStopViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}