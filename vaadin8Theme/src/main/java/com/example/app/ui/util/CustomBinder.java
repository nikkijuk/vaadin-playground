package com.example.app.ui.util;

import com.vaadin.data.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomBinder<BEAN> extends Binder<BEAN> {


    private static final boolean NO_EVENTS = false;
    private static final boolean FIRE_EVENTS = true;

    public CustomBinder(Class<BEAN> beanType) {
        super(BeanPropertySet.get(beanType));
    }

    @Override
    // public method copied from base class - here to show what changes
    public boolean isValid() {
        return validate(NO_EVENTS).isOk();
    }

    @Override
    // public method copied from base class - here to show what changes
    public BinderValidationStatus<BEAN> validate() {
        return validate(FIRE_EVENTS);
    }

    @Override
    // simplified implementation
    protected BinderValidationStatus<BEAN> validate(boolean fireEvent) {

        List<BindingValidationStatus<?>> bindingStatuses = validateFields(fireEvent);
        List<ValidationResult> beanStatus = Collections.emptyList(); // no bean validation, ever;

        BinderValidationStatus<BEAN> validationStatus = new BinderValidationStatus<> (this, bindingStatuses, beanStatus);

        if (fireEvent) {
            getValidationStatusHandler().statusChange(validationStatus);
            fireStatusChangeEvent(validationStatus.hasErrors());
        }

        return validationStatus;
    }

    // internal helper method - compare to : validateBindings()
    private List<BindingValidationStatus<?>> validateFields(boolean fireEvents) {
        return getBindings()
                .stream()
                .map(binding -> binding.validate(fireEvents)) // validata each binding
                .collect(Collectors.toList());
    }

    // private method copied from base class
    private void fireStatusChangeEvent(boolean hasValidationErrors) {
        getEventRouter()
                .fireEvent(new StatusChangeEvent(this, hasValidationErrors));
    }
}