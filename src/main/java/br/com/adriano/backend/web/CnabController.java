package br.com.adriano.backend.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.adriano.backend.domain.CnabService;

@RestController
@RequestMapping("cnab")
public class CnabController {

  private final CnabService service;

  public CnabController(CnabService service) {
    this.service = service;
  }

  @PostMapping("upload")
  public String upload(@RequestParam("file") MultipartFile file) throws Exception {
    service.uploadCnabFile(file);
    return "Processamento iniciado!";
  }
}
