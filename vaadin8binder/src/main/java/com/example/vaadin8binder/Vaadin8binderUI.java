package com.example.vaadin8binder;

import com.vaadin.data.Binder;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.data.ValidationException;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.converter.StringToBigDecimalConverter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.annotations.Theme;

import java.util.List;
import java.util.stream.Collectors;

@Theme("Vaadin8binder")
public class Vaadin8binderUI extends UI{

	// used same names as in bean to simplify binding
	private TextField username = new TextField("Username");
	private TextField email = new TextField("Email");
	private TextField password = new TextField("Password");
    private TextField secret = new TextField("Secret");
    private CheckBox register = new CheckBox("Register");

    private Label messages = new Label ();
    private Label debug = new Label ("Debug");

    private Button doLogin = new Button ("Login");
    private Button doValidate = new Button ("Validate");

    // binder tied to pojo
	private Binder<Login> binder = new Binder<>(Login.class);

	@Override
	protected void init(VaadinRequest request){

	    binder.forMemberField(register);

		// define username binding, is value is not given it's empty
		binder.forMemberField(username).withNullRepresentation("");

		// define email binding, is value is not given it's empty
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

        // writes value back to login pojo
        doLogin.addClickListener(e -> login(login));
        doValidate.addClickListener(e -> validateBinder());

        VerticalLayout layout = new VerticalLayout();
		layout.addComponents(username, email, password, secret, register, messages, debug, doLogin, doValidate);
		setContent(layout);
	}

    private void validateBinder() {
        try {
            if (binder.hasChanges()) {
                // error happens here
                // see: https://github.com/vaadin/framework/issues/9955
                BinderValidationStatus<Login> validationStatus = binder.validate();
                List<ValidationResult> validationErrors = validationStatus.getValidationErrors(); // both bean & field errors
                boolean valid = validationErrors.isEmpty();
                if (!valid) {
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

    private void login(Login l) {
        try {
            if (binder.hasChanges()) {
                binder.writeBean(l); // write buffered changes back to bean
                debug.setValue("values written back to bean");
            } else {
                debug.setValue("no changes at binder");
            }
        } catch (ValidationException e) {
            //e.printStackTrace();
            debug.setValue(e.getMessage());
        }
    }

    private boolean checkUserIdentity(Login l) {
        boolean result = l.getEmail().length() > 0 || l.getUsername().length() > 0;
        //debug.setValue("User id check: "+result);
        return result;
    }
}
