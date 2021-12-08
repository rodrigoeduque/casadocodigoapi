package br.com.rodrigoeduque.casadocodigo.app.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private final String nome;

  public Categoria(String nome) {
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }
}
