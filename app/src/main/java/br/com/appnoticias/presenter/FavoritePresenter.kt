package br.com.appnoticias.presenter

import br.com.appnoticias.model.Article
import br.com.appnoticias.model.data.NewsDataSource

class FavoritePresenter(private val dataSource: NewsDataSource) {

    fun saveArticle(article: Article) {
        this.dataSource.saveArticle(article)
    }
}