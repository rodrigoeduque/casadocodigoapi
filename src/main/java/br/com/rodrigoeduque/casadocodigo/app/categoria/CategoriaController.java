package br.com.rodrigoeduque.casadocodigo.app.categoria;

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
@RequestMapping("/api")
public class CategoriaController {
  @Autowired
  private CategoriaRepository repository;

  @PostMapping("/categorias")
  public ResponseEntity<Categoria> novaCategoria(@RequestBody @Valid NovaCategoriaRequest request) {

    Categoria categoria = request.toModel();
    repository.save(categoria);

    URI uri = UriComponentsBuilder.fromPath("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
