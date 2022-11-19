package app.riyaspullur.lanceversebrowser

import android.R
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import app.riyaspullur.lanceversebrowser.databinding.ActivityBrowsingBinding
import java.util.regex.Matcher
import java.util.regex.Pattern


class BrowsingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBrowsingBinding
    var browserTextEdit: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrowsingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var webUrl = "https://www.google.com/"


        val webSettings = binding.webViewId.settings
        webSettings.javaScriptEnabled = true


        binding.webViewId.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                view.loadUrl(request.url.toString())
                return false
            }
        }
        binding.webViewId.loadUrl(webUrl)



        binding.searchIconIDBrowsing.setOnClickListener {
            browserTextEdit = binding.searchTextEditIDBrowsing.text.toString()



            if (isValidURL(browserTextEdit)) {
                println("Yes");
                binding.webViewId.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView,
                        request: WebResourceRequest
                    ): Boolean {
                        view.loadUrl(request.url.toString())
                        return false
                    }
                }
                binding.webViewId.loadUrl(browserTextEdit!!)
            } else {

                var urlNotValid = "https://$browserTextEdit"


                println("NO");
                binding.webViewId.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView,
                        request: WebResourceRequest
                    ): Boolean {

                        view.loadUrl(request.url.toString())
                        return false
                    }
                }
                binding.webViewId.loadUrl(urlNotValid)


            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.getAction() === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (binding.webViewId.canGoBack()) {
                        binding.webViewId.goBack()
                    } else {
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    fun isValidURL(url: String?): Boolean {
        // Regex to check valid URL
        val regex = ("((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)")

        // Compile the ReGex
        val p: Pattern = Pattern.compile(regex)

        // If the string is empty
        // return false
        if (url == null) {
            return false
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        val m: Matcher = p.matcher(url)

        // Return if the string
        // matched the ReGex
        return m.matches()
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}





