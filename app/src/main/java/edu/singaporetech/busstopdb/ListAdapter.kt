package edu.singaporetech.busstopdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val bus_stop_list : List<BusStopEntity>) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false) as View
        return ListViewHolder(itemView, this)
    }

    override fun getItemCount(): Int {
        return bus_stop_list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.textViewBusStopCode.text = bus_stop_list[position].bus_stop_code
        holder.textViewRoadName.text = bus_stop_list[position].road_name
        holder.textViewBusStopDesc.text = bus_stop_list[position].bus_stop_description

    }
}

class ListViewHolder(itemView: View, adapter: ListAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener
{
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    val textViewBusStopCode = itemView.findViewById<TextView>(R.id.textViewBusStopCode)
    val textViewRoadName = itemView.findViewById<TextView>(R.id.textViewRoadName)
    val textViewBusStopDesc = itemView.findViewById<TextView>(R.id.textViewBusStopDesc)
}