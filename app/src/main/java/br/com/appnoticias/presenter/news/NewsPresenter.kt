package br.com.appnoticias.presenter.news

import br.com.appnoticias.model.NewsResponse
import br.com.appnoticias.presenter.ViewHome
import javax.sql.DataSource

class NewsPresenter(
    val view: ViewHome.View,
    private val dataSource: DataSource
) : NewsHome.Presenter {
    override fun requestAll() {
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