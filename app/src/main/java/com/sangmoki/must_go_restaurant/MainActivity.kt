package com.sangmoki.must_go_restaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<DataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 북마크 객체 생성
        val bookmarkBtn = findViewById<TextView>(R.id.bookmarkBtn)

        // 북마크 TextView 클릭 이벤트
        bookmarkBtn.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        // 데이터 추가
        items.add(
            DataModel(
                url = "https://www.siksinhot.com/P/753148",
                titleImageUrl = "https://img.siksinhot.com/place/1525354730637037.jpg?w=307&h=300&c=Y",
                titleText = "불광동 불쭈꾸미"
            )
        )

        items.add(
            DataModel(
                url = "https://www.siksinhot.com/P/614433",
                titleImageUrl = "https://img.siksinhot.com/place/1525366504322092.jpg?w=307&h=300&c=Y",
                titleText = "연신내 아웃닭"
            )
        )

        items.add(
            DataModel(
                url = "https://www.siksinhot.com/P/691326",
                titleImageUrl = "https://img.siksinhot.com/place/1525325380754005.jpg?w=307&h=300&c=Y",
                titleText = "연신내 공화춘"
            )
        )

        items.add(
            DataModel(
                url = "https://www.siksinhot.com/P/371591",
                titleImageUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20231229_224%2F1703847235687M1Mia_JPEG%2F1.jpeg",
                titleText = "연신내 보들이족발"
            )
        )

        // 어댑터 연결
        val recyclerView = findViewById<RecyclerView>(R.id.rv_restaurant)
        val rvAdapter = RvAdapter(baseContext, items)
        recyclerView.adapter = rvAdapter

        rvAdapter.itemClick = object: RvAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].titleImageUrl)
                startActivity(intent)
            }
        }

        // 레이아웃 구성  =  LinearLayoutManager(this) -> GridLayoutManager(this, 2)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}