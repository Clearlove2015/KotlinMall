package com.odbpo.fenggo.base_library.rx

import rx.Subscriber

open class BaseSubscriber<T>:Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }
}