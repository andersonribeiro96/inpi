package com.inpi.verify.resource;

import com.inpi.verify.domain.Processo;
import com.inpi.verify.service.FilterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
public class processamentoResouce {

    @Autowired
    FilterServices filterServices;


    @GetMapping("/{numeroRevista}")
    public ResponseEntity<List<Processo>> getProcessos(@PathVariable String numeroRevista) throws JAXBException, IOException {
        return ResponseEntity.ok(filterServices.processamento(numeroRevista));
    }

    @GetMapping("/{numeroRevista}/{uf}")
    public ResponseEntity<List<Processo>> getProcessosUf(@PathVariable String numeroRevista, @PathVariable String uf) throws JAXBException, IOException {
        return ResponseEntity.ok(filterServices.processamento(numeroRevista, uf));
    }

    @GetMapping("/processo/{numeroRevista}/{numeroProcesso}")
    public ResponseEntity<List<Processo>> getProcessosProcesso(@PathVariable String numeroRevista, @PathVariable Long numeroProcesso) throws JAXBException, IOException {
        return ResponseEntity.ok(filterServices.processamento(numeroRevista, numeroProcesso));
    }


}
