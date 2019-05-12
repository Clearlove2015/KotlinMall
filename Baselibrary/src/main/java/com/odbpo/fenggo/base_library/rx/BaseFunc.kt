package com.odbpo.fenggo.base_library.rx

import com.odbpo.fenggo.base_library.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }
}