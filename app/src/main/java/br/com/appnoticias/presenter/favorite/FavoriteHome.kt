package br.com.appnoticias.presenter.favorite

import br.com.appnoticias.model.Article

interface FavoriteHome {

    interface Presenter {
        fun onSuccess(articles: List<Article>)
    }
}