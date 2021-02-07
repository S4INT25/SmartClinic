package com.lucky.smartclinic.ui.fragments.home.news

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.lucky.smartclinic.R
import kotlinx.android.synthetic.main.fragment_news_details.*

class NewsDetailsFragment : Fragment(R.layout.fragment_news_details) {
    private val args by navArgs<NewsDetailsFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WebViewNews.loadUrl(args.newsArticle.url)

        WebViewNews.webViewClient =  object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                try {
                    PB_newsDetails.isVisible = false
                }catch (e:Exception)
                {
                    e.printStackTrace()
                }

                super.onPageFinished(view, url)

            }

        }



    }
}