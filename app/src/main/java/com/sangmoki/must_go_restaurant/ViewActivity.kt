package com.sangmoki.must_go_restaurant

import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        val auth = Firebase.auth

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // main에서 넘어온 url 정보를 받는다.
        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageUrl = intent.getStringExtra("imageUrl").toString()

        val saveText = findViewById<TextView>(R.id.saveText)

        // WebView를 사용하여 url로 이동한다.
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(url.toString())

        val database = Firebase.database
        val myBookmark = database.getReference("bookmark_ref")

        saveText.setOnClickListener {
            myBookmark
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(DataModel(url, imageUrl, title))
        }


    }
}