package com.odbpo.fenggo.base_library.ext

import android.view.View
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.base_library.rx.BaseFunc
import com.odbpo.fenggo.base_library.rx.BaseFuncBoolean
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 此处定义一些扩展方法
 */
fun <T> Observable<T>.execute(lifecycleProvider: LifecycleProvider<*>, subscriber: BaseSubscriber<T>) {
    this.subscribeOn(Schedulers.io())
        .compose(lifecycleProvider.bindToLifecycle())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}