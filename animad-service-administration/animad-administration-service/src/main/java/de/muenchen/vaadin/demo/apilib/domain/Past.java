package de.muenchen.vaadin.demo.apilib.domain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation for validation of the LocalDate class
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PastValidator.class)
@Documented
public @interface Past {

    String message() default "Datum muss in der Vergangenheit liegen";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}