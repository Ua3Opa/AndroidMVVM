package com.presentation.internal;

import com.presentation.internal.components.ApplicationComponent;

public class ComponentHolder {
    private static ApplicationComponent sApplicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }

    public static void setApplicationComponent(ApplicationComponent component) {
        sApplicationComponent = component;
    }
}
