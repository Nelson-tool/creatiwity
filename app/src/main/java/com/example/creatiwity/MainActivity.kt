package com.example.creatiwity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popdialog.*
import kotlinx.android.synthetic.main.popdialog.view.*

class MainActivity : AppCompatActivity() {

    private val webView: WebView by lazy { findViewById<WebView>(R.id.webview) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_add_page.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.popdialog, null)
            val builder = AlertDialog.Builder(this).setView(dialogView).setTitle("Add page")
            val alertDialog = builder.show()
            dialogView.button_start.setOnClickListener {
                alertDialog.dismiss()
                val url = alertDialog.dialogUrl.text.toString()
                val name = alertDialog.Name.text.toString()
                val text = alertDialog.test.text.toString()
                Log.d("ok", url)
                if (!url.isBlank()) {
                    webview.webViewClient = WebViewClient()
                    webView.visibility = View.VISIBLE
                    webView.loadUrl("https://google.com")
                } else
                    textviewsection.text = "Text:" + text
            }
        }
    }
}
