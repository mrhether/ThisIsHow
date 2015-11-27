package com.markhetherington.thisishow.ui.controllers;

import android.support.annotation.CallSuper;
import android.util.Log;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by markhetherington on 2015-11-19.
 */
public abstract class BaseViewController<LISTENER> {

    protected WeakHashMap<LISTENER, Object> mListeners = new WeakHashMap<>();

    @CallSuper
    public void subscribe(LISTENER listener) {
        mListeners.put(listener, new Object());
        onListenerAdded();
    }

    @CallSuper
    public void unsubscribe(LISTENER listener) {
        mListeners.remove(listener);
    }

    protected void onListenerAdded() {
    }

    protected void inform(listenerCall<LISTENER> listenerCall) {
        for (LISTENER listener : mListeners.keySet()) {
            listenerCall.update(listener);
        }
    }

    public interface listenerCall<L> {
        void update(L listener);
    }

}
