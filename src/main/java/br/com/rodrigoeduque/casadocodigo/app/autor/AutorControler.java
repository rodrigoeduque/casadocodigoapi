package br.com.rodrigoeduque.casadocodigo.app.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api")
public class AutorControler {

  @Autowired
  private AutorRepository repository;

  @PostMapping(value = "/autores")
  public ResponseEntity<Autor> novoAutor(@RequestBody @Valid NovoAutorRequest request){

    Autor autor = request.toModel();
    repository.save(autor);

    URI uri = UriComponentsBuilder.fromPath("/categorias/{id}").buildAndExpand(autor.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
