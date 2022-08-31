package br.com.appnoticias.presenter.favorite

import br.com.appnoticias.model.Article
import br.com.appnoticias.model.data.NewsDataSource
import br.com.appnoticias.presenter.ViewHome

class FavoritePresenter(
    val view: ViewHome.Favorite,
    private val dataSource: NewsDataSource): FavoriteHome.Presenter {

    fun getAll() {
        this.dataSource.getAllArticle(this)
    }

    fun saveArticle(article: Article) {
        this.dataSource.saveArticle(article)
    }

    override fun onSuccess(articles: List<Article>) {
        this.view.showArticles(articles)
    }
}