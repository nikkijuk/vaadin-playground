package com.example.app.ui.util;

import com.vaadin.data.*;

public class CustomBinder<BEAN> extends Binder<BEAN> {

    private static final boolean FIRE_EVENT = false;

    public CustomBinder(Class<BEAN> beanType) {
        super(BeanPropertySet.get(beanType));
    }

    @Override
    public boolean isValid() {
        boolean hasErrors = getBindings().stream()
                .map(binding -> binding.validate(FIRE_EVENT))
                .anyMatch(validationStatus -> validationStatus.isError());
        return !hasErrors;
    }

}