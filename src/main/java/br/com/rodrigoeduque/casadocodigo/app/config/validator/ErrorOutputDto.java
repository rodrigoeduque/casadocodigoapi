package br.com.rodrigoeduque.casadocodigo.app.config.validator;

public class ErrorOutputDto {

  private String timestamp;
  private String campo;
  private String mensagem;

  public ErrorOutputDto(String timestamp, String campo, String mensagem) {
    this.timestamp = timestamp;
    this.campo = campo;
    this.mensagem = mensagem;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public String getCampo() {
    return campo;
  }

  public String getMensagem() {
    return mensagem;
  }
}
