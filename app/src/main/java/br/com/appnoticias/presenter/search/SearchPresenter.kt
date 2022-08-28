package br.com.appnoticias.presenter.search

import br.com.appnoticias.model.NewsResponse
import br.com.appnoticias.presenter.ViewHome
import javax.sql.DataSource

class SearchPresenter(
    val view: ViewHome.View,
    private val dataSource: DataSource
) : SearchHome.Presenter {
    override fun search(term: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(newsResponse: NewsResponse) {
        TODO("Not yet implemented")
    }

    override fun onError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onComplete() {
        TODO("Not yet implemented")
    }
}