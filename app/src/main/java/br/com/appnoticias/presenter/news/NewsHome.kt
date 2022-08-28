package br.com.appnoticias.presenter.news

import br.com.appnoticias.model.NewsResponse

interface NewsHome {

    interface Presenter {
        fun requestAll()
        fun onSuccess(newsResponse: NewsResponse)
        fun onError(message: String)
        fun onComplete()
    }
}