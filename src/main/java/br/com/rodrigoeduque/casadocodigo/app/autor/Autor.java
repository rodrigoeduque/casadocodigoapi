package br.com.rodrigoeduque.casadocodigo.app.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String descricao;
  private LocalDateTime instanteCriacao;


  public Autor(String nome, String email, String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
    this.instanteCriacao = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }
}
