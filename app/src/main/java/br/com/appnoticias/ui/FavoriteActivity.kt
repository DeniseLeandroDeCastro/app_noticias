package br.com.appnoticias.ui

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.appnoticias.R
import br.com.appnoticias.adapter.MainAdapter
import br.com.appnoticias.model.Article
import br.com.appnoticias.model.data.NewsDataSource
import br.com.appnoticias.presenter.ViewHome
import br.com.appnoticias.presenter.favorite.FavoritePresenter
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_main.*

class FavoriteActivity : AbstractActivity(), ViewHome.Favorite {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: FavoritePresenter

    override fun getLayout(): Int = R.layout.activity_favorite

    override fun onInject() {
        val dataSource = NewsDataSource(this)
        presenter = FavoritePresenter(this, dataSource)
        presenter.getAll()
        configRecycle()
        clickAdapter()
    }

    private fun configRecycle() {
        with(rvFavorite) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            addItemDecoration(
                DividerItemDecoration(
                this@FavoriteActivity, DividerItemDecoration.VERTICAL
            )
            )
        }
    }

    private fun clickAdapter() {
        mainAdapter.setOnClickListener { article ->
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("article", article)
            startActivity(intent)
        }
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}