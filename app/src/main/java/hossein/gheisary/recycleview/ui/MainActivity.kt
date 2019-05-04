package hossein.gheisary.recycleview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import hossein.gheisary.recycleview.R
import hossein.gheisary.recycleview.itemanimators.SlideInOutRightAnimator
import hossein.gheisary.recycleview.model.DataGenerator
import hossein.gheisary.recycleview.model.ListItem
import kotlinx.android.synthetic.main.activity_main.*

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
        mainRecyclerView.itemAnimator = SlideInOutRightAnimator(mainRecyclerView)
        mainRecyclerView.adapter = itemArrayAdapter

        itemList = DataGenerator.get()
        itemArrayAdapter.submitList(itemList)
    }
}