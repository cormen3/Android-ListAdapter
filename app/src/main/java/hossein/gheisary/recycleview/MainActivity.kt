package hossein.gheisary.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(){
    private lateinit var itemList : List<ListItem>
    private lateinit var itemArrayAdapter : ItemArrayAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupList()

        btnRefresh.setOnClickListener {
            itemList = DataGenerator.get()
            itemArrayAdapter.submitList(itemList)
        }
    }

    private fun setupList() {
        itemArrayAdapter = ItemArrayAdapter()
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.itemAnimator = DefaultItemAnimator()
        mainRecyclerView.adapter = itemArrayAdapter

        itemList = DataGenerator.get()
        itemArrayAdapter.submitList(itemList)
    }
}