package app.com.biocubesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import app.com.biocubesproject.adapter.RecyclerAdapter
import app.com.biocubesproject.model.Banner
import app.com.biocubesproject.model.HealthData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter: RecyclerAdapter? = null

    val healthCareList = ArrayList<HealthData>()

    //    private val healthCareList = listOf(
    val healthData1 = HealthData("Dental Care", "Book an Appointment", 2)
    val healthData2 = HealthData("Eye Care", "Book an Appointment", 2)
    val healthData3 = HealthData("Heart Care", "Book an Appointment", 2)
    val healthData4 = HealthData("Mental Health Care", "Book an Appointment", 2)
    val healthData5 = HealthData("orthopedic", "Book an Appointment", 2)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var banner =
            Banner(getString(R.string.your_health_is_our_concern), getString(R.string.lorem_ipsum))
        setRecycleAdapter()
    }

    private fun setRecycleAdapter() {
        recycle_doctor.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(this, healthCareList as ArrayList<HealthData>)
        recycle_doctor.adapter = adapter
    }
}
