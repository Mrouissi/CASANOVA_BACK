package com.istic.casanova.validator.annotation;

import com.istic.casanova.validator.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface UniqueEmail {

    public String message() default "Email déjà utilisé";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default{};

}
