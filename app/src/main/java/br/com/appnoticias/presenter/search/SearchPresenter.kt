package br.com.appnoticias.presenter.search

import br.com.appnoticias.model.NewsResponse
import br.com.appnoticias.model.data.NewsDataSource
import br.com.appnoticias.presenter.ViewHome
import javax.sql.DataSource

class SearchPresenter(
    val view: ViewHome.View,
    private val dataSource: NewsDataSource
) : SearchHome.Presenter {

    override fun search(term: String) {
        this.view.showProgressBar()
        this.dataSource.searchNews(term, this)
    }

    override fun onSuccess(newsResponse: NewsResponse) {
        this.view.showArticles(newsResponse.articles)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }
}