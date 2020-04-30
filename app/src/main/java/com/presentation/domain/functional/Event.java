package com.presentation.domain.functional;

import dagger.internal.Preconditions;

public class Event<T> {

    private T mContent;

    public Event(T content) {
        Preconditions.checkNotNull(content);
        this.mContent = content;
    }

    public T peekContent() {
        return mContent;
    }

}
