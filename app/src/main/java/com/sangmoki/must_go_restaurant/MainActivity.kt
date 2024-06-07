package com.sangmoki.must_go_restaurant

import android.os.Bundle
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

        // 데이터 추가
        items.add(
            DataModel(
                url = "https://map.naver.com/p/search/%EB%B6%88%EC%AD%88%EA%BE%B8%EB%AF%B8/place/35749600?placePath=%3Fentry%3Dpll%26from%3Dnx%26fromNxList%3Dtrue&placeSearchOption=entry%3Dpll%26fromNxList%3Dtrue&searchType=place",
                titleImageUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230725_245%2F1690279577119GgE7p_JPEG%2F20230725_190024.jpg",
                titleText = "불광동 불쭈꾸미"
            )
        )

        items.add(
            DataModel(
                url = "https://map.naver.com/p/search/%EC%97%B0%EC%8B%A0%EB%82%B4%20%EC%B9%98%ED%82%A8/place/410278544?placePath=?entry=pll&from=nx&fromNxList=true&searchType=place&c=15.00,0,0,0,dh",
                titleImageUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fpup-review-phinf.pstatic.net%2FMjAyNDA1MjFfMTE0%2FMDAxNzE2MjYzOTE4NTY3.RDSga6W41ZfymCUml2fuPAzRdmq6NfjMXEhIslGFUz4g.dSnKqL9bOcfJqPeSbuSRqmQQPdoL9ImeqNMxH55nGMEg.JPEG%2F20240520_165041.heic.jpg%3Ftype%3Dw1500_60_sharpen",
                titleText = "연신내 아웃닭"
            )
        )

        items.add(
            DataModel(
                url = "https://map.naver.com/p/search/%EB%B6%88%EC%AD%88%EA%BE%B8%EB%AF%B8/place/35749600?placePath=%3Fentry%3Dpll%26from%3Dnx%26fromNxList%3Dtrue&placeSearchOption=entry%3Dpll%26fromNxList%3Dtrue&searchType=place\",",
                titleImageUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20240328_299%2F1711613859780dqeqy_JPEG%2FIMG_0655.JPEG",
                titleText = "연신내 단토리"
            )
        )

        items.add(
            DataModel(
                url = "https://map.naver.com/p/search/%EC%97%B0%EC%8B%A0%EB%82%B4%20%EB%B3%B4%EB%93%A4%EC%9D%B4%EC%A1%B1%EB%B0%9C/place/19878328?c=15.00,0,0,0,dh&isCorrectAnswer=true",
                titleImageUrl = "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20231229_224%2F1703847235687M1Mia_JPEG%2F1.jpeg",
                titleText = "연신내 보들이족발"
            )
        )

        // 어댑터 연결
        val recyclerView = findViewById<RecyclerView>(R.id.rv_restaurant)
        val rvAdapter = RvAdapter(baseContext, items)
        recyclerView.adapter = rvAdapter

        // 레이아웃 구성  =  LinearLayoutManager(this) -> GridLayoutManager(this, 2)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}