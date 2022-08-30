package br.com.appnoticias.presenter.favorite

import br.com.appnoticias.model.Article

interface FavoriteHome {

    fun showArticles(articles: List<Article>)
}