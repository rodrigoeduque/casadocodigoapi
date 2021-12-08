package br.com.rodrigoeduque.casadocodigo.app.config.validator.anotation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

  @PersistenceContext
  private EntityManager manager;

  private String domainAttribute;
  private Class<?> klass;


  @Override
  public void initialize(UniqueValue constraintAnnotation) {
    domainAttribute = constraintAnnotation.fieldName();
    klass = constraintAnnotation.domainClass();
  }

  @Override
  public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
    Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
    query.setParameter("value", o);
    List<?> resultList = query.getResultList();
    return resultList.isEmpty();
  }
}
