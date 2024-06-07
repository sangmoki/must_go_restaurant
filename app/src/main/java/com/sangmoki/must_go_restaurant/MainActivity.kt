package com.sangmoki.must_go_restaurant

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        // 데이터 추가
        items.add(
            DataModel(
                url = "https://map.naver.com/p/search/%EB%B6%88%EC%AD%88%EA%BE%B8%EB%AF%B8/place/35749600?placePath=%3Fentry%3Dpll%26from%3Dnx%26fromNxList%3Dtrue&placeSearchOption=entry%3Dpll%26fromNxList%3Dtrue&searchType=place",
                titleImageUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230725_245%2F1690279577119GgE7p_JPEG%2F20230725_190024.jpg",
                titleText = "불광동 불쭈꾸미"
            )
        )

        // 어댑터 연결
        val recyclerView = findViewById<RecyclerView>(R.id.rv_restaurant)
        val rvAdapter = RvAdapter(items)
        recyclerView.adapter = rvAdapter

        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

    }
}