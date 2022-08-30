package br.com.appnoticias.presenter.news

import br.com.appnoticias.model.NewsResponse
import br.com.appnoticias.model.data.NewsDataSource
import br.com.appnoticias.presenter.ViewHome
import javax.sql.DataSource

class NewsPresenter(
    val view: ViewHome.View,
    private val dataSource: NewsDataSource
) : NewsHome.Presenter {

    override fun requestAll() {
        this.view.showProgressBar()
        this.dataSource.getBreakingNews(this)
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