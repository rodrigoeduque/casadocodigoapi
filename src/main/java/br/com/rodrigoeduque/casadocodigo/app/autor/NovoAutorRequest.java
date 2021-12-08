package br.com.rodrigoeduque.casadocodigo.app.autor;

import br.com.rodrigoeduque.casadocodigo.app.config.validator.anotation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

  @NotBlank
  private final String nome;
  @NotBlank
  @Email
  @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Este e-mail já foi cadastrado anteriormente")
  private final String email;
  @NotBlank
  @Size(max = 400)
  private final String descricao;

  public NovoAutorRequest(String nome, String email, String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  public Autor toModel() {
    return new Autor(this.nome, this.email, this.descricao);
  }
}
