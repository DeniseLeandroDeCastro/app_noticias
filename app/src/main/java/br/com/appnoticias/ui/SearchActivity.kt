package br.com.appnoticias.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.appnoticias.R
import br.com.appnoticias.adapter.MainAdapter
import br.com.appnoticias.model.Article
import br.com.appnoticias.model.data.NewsDataSource
import br.com.appnoticias.presenter.ViewHome
import br.com.appnoticias.presenter.search.SearchPresenter
import br.com.appnoticias.util.UtilQueryTextListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: SearchPresenter

    override fun getLayout(): Int = R.layout.activity_search

    override fun onInject() {

        val dataSource = NewsDataSource()
        presenter = SearchPresenter(this, dataSource)
        configRecycle()
        search()
        clickAdapter()
    }

    private fun search() {
        searchNews.setOnQueryTextListener(
            UtilQueryTextListener (
                this.lifecycle
            ) {
                newText ->
                newText?.let { query ->
                    if (query.isNotEmpty()) {
                        presenter.search(query)
                        progressBarSearch.visibility = View.VISIBLE
                    }
                }
            }
        )
    }

    private fun configRecycle() {
        with(rvSearch) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            addItemDecoration(
                DividerItemDecoration(
                this@SearchActivity, DividerItemDecoration.VERTICAL
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

    override fun showProgressBar() {
        progressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        progressBarSearch.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}