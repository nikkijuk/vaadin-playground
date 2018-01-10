package com.example.app.ui.views;

import com.example.app.ui.model.Login;
import com.google.inject.Inject;
import com.vaadin.data.*;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.guice.annotation.GuiceView;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Login view. Here's content from previous experiment
 */
@GuiceView("form") // all other views except start view need to have unique name
public class FormView extends Panel implements View {

    // used same names as in bean to simplify binding
    private TextField username = new TextField("Username");
    private TextField email = new TextField("Email");
    private TextField password = new TextField("Password");
    private TextField secret = new TextField("Secret");
    private CheckBox register = new CheckBox("Register");

    private Label messages = new Label ();
    private Label debug = new Label ("Debug");
    private Label log = new Label ("Log");

    private Button doLogin = new Button ("Login");
    private Button doValidate = new Button ("Validate");
    private Button doIsValid = new Button ("isValid");

    // binder tied to pojo
    private Binder<Login> binder = new Binder<>(Login.class);

    @Inject
    FormView(){
        super("login view");
        init();
    }

    protected void init(){

        // simplest form of defining binding
        // bindings for all member fields are closed when Binder.bindInstanceFields () is called
        binder.forMemberField(register);

        // define username binding, if value is not given it's empty (=null)
        binder.forMemberField(username).withNullRepresentation("");

        // define email binding, if value is not given it's empty (=null)
        binder.forMemberField(email).withNullRepresentation("");

        // define secret code, null presentation, and converter
        binder.forMemberField(secret)
                .withNullRepresentation("")
                .withConverter(new StringToBigDecimalConverter("Conversion error"));

        // close bindings which are done with forMemberField
        binder.bindInstanceFields(this);

        // add password validation
        binder.forField(password)
                .asRequired("Password can't be empty")
                .withValidator(pw -> pw.length() > 8, "Password too short")
                .bind("password");

        // add binder level validator
        binder.withValidator(l -> checkUserIdentity(l), "Username or email needs to be given" );

        // set label for bean level error messages
        binder.setStatusLabel(messages);

        // create login bean
        Login login = new Login();

        // write bean to form, buffered
        binder.readBean(login);

        // listen validation status changes
        binder.addStatusChangeListener(e -> validationStatusChanged(e));

        // writes value back to login pojo
        doLogin.addClickListener(e -> login(login));
        doValidate.addClickListener(e -> validateBinder());
        doIsValid.addClickListener(e -> isValidBinder());

        VerticalLayout layout = new VerticalLayout();
        layout.addComponents(username, email, password, secret, register, messages, debug, log, doLogin, doValidate, doIsValid);
        setContent(layout);
    }
    private void validationStatusChanged (StatusChangeEvent e) {
        //  this works

        // changes can be queried by asking binder instance from event
        boolean hasChanges = e.getBinder().hasChanges();

        // field level validation result can be queried using StatusChangeEvent.hasValidationErrors()
        boolean isValid = !e.hasValidationErrors();

        doLogin.setEnabled(hasChanges && isValid);
    }

    private void validateBinder() {
        try {
            if (binder.hasChanges()) {
                // error happens here
                // validate tries to run bean level validators and error is fired as there's no bound bean
                // as we use buffered mode (readBean/WriteBean) instead of unbuffered (setBean)
                // see: https://github.com/vaadin/framework/issues/9955
                BinderValidationStatus<Login> validationStatus = binder.validate();
                List<ValidationResult> validationErrors = validationStatus.getValidationErrors();
                boolean isValid = validationErrors.isEmpty();
                if (!isValid) {
                    String msg = validationErrors
                            .stream()
                            .map(error -> error.getErrorMessage())
                            .collect(Collectors.joining(", "));
                    debug.setValue(msg);
                } else {
                    debug.setValue("no binder validation errors");
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            debug.setValue(e.getMessage());
        }
    }

    private void isValidBinder() {
        try {
            // error happens here. works similarly to validate(), look above for description
            // see: https://github.com/vaadin/framework/issues/9955
            boolean isValid = binder.isValid();
            debug.setValue("binder valid : "+isValid);
        } catch (Exception e) {
            //e.printStackTrace();
            debug.setValue(e.getMessage());
        }
    }

    private void login(Login l) {
        try {
            if (binder.hasChanges()) {
                // write buffered changes back to bean
                // bean level validation happends here as expected
                binder.writeBean(l);
                debug.setValue("values written back to bean");
            } else {
                debug.setValue("no changes at binder");
            }
        } catch (ValidationException e) {
            //e.printStackTrace();
            debug.setValue(e.getMessage());
        }
    }

    /**
     * Bean level validation logic for user identity
     *
     * @param l
     * @return
     */
    private boolean checkUserIdentity(Login l) {
        // note: this works as we have given empty as null thru null representation on binding
        String email = l.getEmail();
        String username = l.getUsername();
        boolean isValid = email != null || username != null;
        String logMsg = "email '"+email+"' and username '"+ username +"' validated, validation result = "+isValid;
        log.setValue(logMsg);
        return isValid;
    }

}
