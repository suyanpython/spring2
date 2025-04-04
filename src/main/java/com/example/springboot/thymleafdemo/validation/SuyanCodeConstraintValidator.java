package com.example.springboot.thymleafdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SuyanCodeConstraintValidator implements ConstraintValidator<SuyanCode, String> {

    private String suyanPrefix;

    @Override
    public void initialize(SuyanCode theSuyanCode) {
        suyanPrefix = theSuyanCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theconstraintValidatorContext) {
        if (theCode != null){
            boolean result = theCode.startsWith(suyanPrefix);
            return result;
        }else{
            return false;
        }

    }
}
