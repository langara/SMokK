package pl.mareklangiewicz.rxmock

import io.reactivex.Observable
import io.reactivex.Single

fun webSearch(
    inputTextChangeS: Observable<String>,
    inputMinLength: Int,
    webSearchCall: (String) -> Single<List<String>>
): Observable<List<String>> =
    inputTextChangeS
        .filter { it.length >= inputMinLength }
        .distinctUntilChanged()
        .switchMapSingle { webSearchCall(it) }

