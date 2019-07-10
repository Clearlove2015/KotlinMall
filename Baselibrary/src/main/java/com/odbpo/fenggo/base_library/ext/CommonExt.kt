package com.odbpo.fenggo.base_library.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.kotlin.base.utils.GlideUtils
import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import com.odbpo.fenggo.base_library.rx.BaseFunc
import com.odbpo.fenggo.base_library.rx.BaseFuncBoolean
import com.odbpo.fenggo.base_library.rx.BaseSubscriber
import com.odbpo.fenggo.base_library.widgets.DefaultTextWatcher
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

fun Button.enable(et:EditText,method:()->Boolean){
    val btn = this
    et.addTextChangedListener(object :DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}

/*
    ImageView加载网络图片
 */
fun ImageView.loadUrl(url: String) {
    GlideUtils.loadUrlImage(context, url, this)
}