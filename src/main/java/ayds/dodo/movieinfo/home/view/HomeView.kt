package ayds.dodo.movieinfo.home.view

import ayds.observer.Observable

interface HomeView {
    fun error()
    fun openView()
    val movieTitle: String
    fun onUiEvent(): Observable<UiEvent>
}