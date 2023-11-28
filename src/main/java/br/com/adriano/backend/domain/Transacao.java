package br.com.adriano.backend.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public record Transacao(
    Long id,
    Integer tipo,
    Date data,
    BigDecimal valor,
    Long cpf,
    String cartao,
    Time hora,
    String donoDaLoja,
    String nomeDaLoja) {

  public Transacao withValor(BigDecimal valor) {
    return new Transacao(
        id, tipo, data,
        valor,
        cpf, cartao, hora,
        donoDaLoja, nomeDaLoja);
  }

  public Transacao withData(String date) throws ParseException {
    var dtFormat = new SimpleDateFormat("yyyyMMdd");
    var dt = dtFormat.parse(date);

    return new Transacao(
        id, tipo, new Date(dt.getTime()),
        valor, cpf,
        cartao, hora,
        donoDaLoja, nomeDaLoja);
  }

  public Transacao withHora(String time) throws ParseException {
    var dtFormat = new SimpleDateFormat("HHmmss");
    var date = dtFormat.parse(time);

    return new Transacao(
        id, tipo, data,
        valor, cpf,
        cartao, new Time(date.getTime()),
        donoDaLoja, nomeDaLoja);
  }
}
