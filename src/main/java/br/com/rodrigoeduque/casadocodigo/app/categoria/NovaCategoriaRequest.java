package br.com.rodrigoeduque.casadocodigo.app.categoria;

import br.com.rodrigoeduque.casadocodigo.app.config.validator.anotation.UniqueValue;

import javax.validation.constraints.NotBlank;


public class NovaCategoriaRequest {

  @NotBlank
  @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já existe")
  private String nome;

  public NovaCategoriaRequest() {
  }

  public NovaCategoriaRequest(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return "NovaCategoriaRequest{" +
        "nome='" + nome + '\'' +
        '}';
  }

  public Categoria toModel() {
    return new Categoria(this.nome);
  }
}
