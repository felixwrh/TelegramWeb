package edu.singaporetech.busstopdb

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.view.KeyEvent.KEYCODE_BACK
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class AddBusStopActivity : AppCompatActivity() {
    private lateinit var viewModel : BusStopViewModel
    private val TAG : String = "Add Bus Stop Activity"
    private lateinit var bus_stop_code_et : EditText
    private lateinit var road_name_et : EditText
    private lateinit var bus_stop_description_et : EditText

    private lateinit var preferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bus_stop)



        // Initialize the view model
        val butStopViewModelFactory : BusStopViewModelFactory = BusStopViewModelFactory(applicationContext)
        viewModel = ViewModelProvider(this, butStopViewModelFactory).get(BusStopViewModel::class.java)

        // Get all the views from add_bus_stop.xml
        bus_stop_code_et = findViewById<EditText>(R.id.editTextBusStopCode)
        road_name_et = findViewById<EditText>(R.id.editTextRoadName)
        bus_stop_description_et = findViewById<EditText>(R.id.editTextBusStopDesc)
        val add_btn = findViewById<Button>(R.id.buttonAdd)
        val clear_btn = findViewById<Button>(R.id.buttonClear)


        // Initialize Shared Preference
        preferences = getSharedPreferences("PREFS", 0)
        val pref_bus_stop_code = preferences.getString("BUS_STOP_CODE", "") // Attempts to get from local storage.
        val pref_road_name = preferences.getString("ROAD_NAME", "") // Attempts to get from local storage.
        val pref_bus_stop_desc = preferences.getString("BUS_STOP_DESC", "") // Attempts to get from local storage.

        if(pref_bus_stop_code != "" && pref_road_name != "" && pref_bus_stop_desc != ""){
            bus_stop_code_et.setText(pref_bus_stop_code)
            road_name_et.setText(pref_road_name)
            bus_stop_description_et.setText(pref_bus_stop_desc)
        }

        add_btn.setOnClickListener {
            val bus_stop_code = bus_stop_code_et.text.toString()
            val road_name = road_name_et.text.toString()
            val bus_stop_description = bus_stop_description_et.text.toString()
            if(isInputValid(bus_stop_code, road_name, bus_stop_description)){

                val bus_stop_obj = BusStopEntity(bus_stop_code, road_name, bus_stop_description)
                val add = viewModel.add(bus_stop_obj)

                finish()
            }
            else{
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            }
        }



    }

    fun isInputValid(bus_stop_code : String, road_name : String, bus_stop_description : String) : Boolean {
        // Checking for empty strings
        if(bus_stop_code.equals("") || road_name.equals("") || bus_stop_description.equals("")) return false
        for (char in bus_stop_code){
            if(!char.isDigit()) return false
        }
        return true
    }

    override fun onPause() {
        super.onPause()
        val editor : SharedPreferences.Editor = preferences.edit()
        editor.putString("BUS_STOP_CODE", bus_stop_code_et.text.toString())  // Saves into local storage.
        editor.putString("ROAD_NAME", road_name_et.text.toString())  // Saves into local storage.
        editor.putString("BUS_STOP_DESC", bus_stop_description_et.text.toString())  // Saves into local storage.
        editor.apply()
    }
}

