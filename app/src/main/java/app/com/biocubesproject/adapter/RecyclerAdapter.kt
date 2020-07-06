package app.com.biocubesproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.com.biocubesproject.R
import app.com.biocubesproject.model.HealthData
import java.lang.IllegalArgumentException

class RecyclerAdapter(var context : Context, var healthDataList: ArrayList<HealthData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

   private val HEADER_ITEM_TYPE = 1
   private val ROW_ITEM_TYPE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  when(viewType) {

            HEADER_ITEM_TYPE -> {
                val view =  LayoutInflater.from(context).inflate(R.layout.header_layout, parent, false)
                HeaderViewHolder(view);
            }

            ROW_ITEM_TYPE -> {
                val view =  LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
                 ViewHolder(view);
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = healthDataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val healthData  = healthDataList[position]
        when(healthData.viewType) {
            1 -> (holder as HeaderViewHolder).bindData()
            2 -> (holder as ViewHolder).bindData()
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when(healthDataList[position].viewType) {
            1 -> HEADER_ITEM_TYPE
            2 -> ROW_ITEM_TYPE

            else -> -1
        }
    }

   class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       fun bindData(){

       }

   }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(){

        }
    }


}