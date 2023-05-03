package tw.edu.pu.dmwd.natalie.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    lateinit var btnBack: Button
    lateinit var webv: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        webv = findViewById(R.id.webv)

        val website:String? = intent.getStringExtra("website")

        if (website != null){
            // 如果想讓網頁顯示在自己的WebView上

            webv.setWebViewClient(WebViewClient())
            //允許網頁使用JavaScript

            webv.settings.javaScriptEnabled = true

            webv.loadUrl(website)}

        btnBack = findViewById(R.id.btnBack)

        btnBack.setOnClickListener({

            finish()
        })

    }
    override fun onBackPressed(){

        if (webv.canGoBack()){

            webv.goBack()

        }

        else{

            finish()

        }

    }
}