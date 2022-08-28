package br.com.appnoticias.presenter.search

import br.com.appnoticias.model.NewsResponse

interface SearchHome {

    interface Presenter {
        fun search(term: String)
        fun onSuccess(newsResponse: NewsResponse)
        fun onError(message: String)
        fun onComplete()
    }
}