package edu.singaporetech.busstopdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 *  ICT2105 Quiz 2
 *  Some comments here?
 */
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : BusStopViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the view model
        val butStopViewModelFactory : BusStopViewModelFactory = BusStopViewModelFactory(applicationContext)
        viewModel = ViewModelProvider(this, butStopViewModelFactory).get(BusStopViewModel::class.java)

        // TODO implement floating action button
        val viewManager = LinearLayoutManager(this)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerViewBusStops)
        val fab : FloatingActionButton = findViewById(R.id.fabAdd)


        fab.setOnClickListener {
            val intent = Intent(this, AddBusStopActivity::class.java)
            startActivity(intent)
        }

        viewModel.busStopList.observe(this, Observer {busStops ->
            var viewAdapter : ListAdapter = ListAdapter(busStops)
            recyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })

    }

    // TODO need to create a separate classes for the relational database elsewhere? (not here!)
}
