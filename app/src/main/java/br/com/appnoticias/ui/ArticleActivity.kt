package br.com.appnoticias.ui

import android.webkit.WebViewClient
import br.com.appnoticias.R
import br.com.appnoticias.model.Article
import br.com.appnoticias.model.data.NewsDataSource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AbstractActivity() {

    private lateinit var article: Article

    override fun getLayout(): Int = R.layout.activity_article

    override fun onInject() {
        getArticle()
        val dataSource = NewsDataSource(this)

        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { url ->
                loadUrl(url)
            }
        }

        fab.setOnClickListener {
            dataSource.saveArticle(article)
            Snackbar.make( it, R.string.article_saved_successful, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun getArticle() {
        intent.extras?.let { articleSend ->
            article = articleSend.get("article") as Article
        }
    }
}