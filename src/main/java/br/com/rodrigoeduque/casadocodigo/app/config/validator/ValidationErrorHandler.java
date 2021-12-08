package br.com.rodrigoeduque.casadocodigo.app.config.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {
  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErrorOutputDto> handle(MethodArgumentNotValidException exception) {
    List<ErrorOutputDto> dto = new ArrayList<>();

    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    fieldErrors.forEach(fieldError -> {
      String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
      ErrorOutputDto erro = new ErrorOutputDto(Instant.now(Clock.systemDefaultZone()).toString(), fieldError.getField(), fieldError.getDefaultMessage());
      dto.add(erro);
    });
    return dto;
  }
}
