package br.com.appnoticias.util

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class UtilQueryTextListener(
    lifecycle: Lifecycle,
    private val utilQueryTextListener: (String?) -> Unit
) : SearchView.OnQueryTextListener, LifecycleObserver {

    private val coroutinScope = lifecycle.coroutineScope
    private var searchJob: Job? = null

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        searchJob?.cancel()
        searchJob = coroutinScope.launch {
            newText?.let {
                delay(Constants.SEARCH_NEWS_DELAY)
                utilQueryTextListener(newText)
            }
        }
        return false
    }
}