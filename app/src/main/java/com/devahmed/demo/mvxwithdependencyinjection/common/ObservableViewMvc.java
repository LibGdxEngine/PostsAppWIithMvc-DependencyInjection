package com.devahmed.demo.mvxwithdependencyinjection.common;

public interface ObservableViewMvc<ListenerType> extends MvcView {

    void registerListener(ListenerType listenerType);

    void unregisterListener(ListenerType listenerType);


}
