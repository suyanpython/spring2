package com.example.springboot.thymleafdemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SuyanCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SuyanCode {
    public String value() default "S";

    public String message() default "must begin with S";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
