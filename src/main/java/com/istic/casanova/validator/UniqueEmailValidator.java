package com.istic.casanova.validator;

import com.istic.casanova.repository.UserRepository;
import com.istic.casanova.service.AppUserDetailsService;
import com.istic.casanova.validator.annotation.UniqueEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isEmailUse = false;
        try {
            isEmailUse = appUserDetailsService.isEmailUse(s);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return s != null && !isEmailUse;
    }
}
