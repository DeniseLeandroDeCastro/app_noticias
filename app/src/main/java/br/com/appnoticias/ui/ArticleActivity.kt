package br.com.appnoticias.ui

import android.webkit.WebViewClient
import br.com.appnoticias.R
import br.com.appnoticias.model.Article
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AbstractActivity() {

    private lateinit var article: Article

    override fun getLayout(): Int = R.layout.activity_article

    override fun onInject() {

        getArticle()

        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { url ->
                loadUrl(url)
            }
        }
    }

    private fun getArticle() {
        intent.extras?.let { articleSend ->
            article = articleSend.get("article") as Article
        }
    }
}