package com.odbpo.fenggo.base_library.ext

import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber)
}