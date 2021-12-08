package br.com.rodrigoeduque.casadocodigo.app.config.validator.anotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueValueValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
  String message() default "Valor já existente";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  String fieldName();
  Class<?> domainClass();
}
