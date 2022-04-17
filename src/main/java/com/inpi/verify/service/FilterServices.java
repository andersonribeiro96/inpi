package com.inpi.verify.service;

import com.inpi.verify.domain.Processo;
import com.inpi.verify.domain.Revista;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.inpi.verify.shared.download.dowloadFile;
import static com.inpi.verify.shared.unzip.unzipFile;

@Service
public class FilterServices {

    public List<Processo> processamento(String numeroRevista) throws JAXBException, IOException {
        return buscarRevista(numeroRevista).getProcesso().stream()
            .filter(processo -> Objects.nonNull(processo.getTitulares()))
            .filter(processo -> processo.getTitulares().getTitular().getUf().equalsIgnoreCase("AL"))
            .collect(Collectors.toList());
    }



    public List<Processo> processamento(String numeroRevista, Long numeroProcesso) throws JAXBException, IOException {
        List<String> strings = List.of("918725917", "922036756", "922957797");

        List<Processo> processos = new ArrayList<>();

        List<Processo> collect = buscarRevista(numeroRevista).getProcesso().stream()
            .filter(processo -> strings.contains(processo.getNumero())).collect(Collectors.toList());


        return collect;
    }

    public List<Processo> processamento(String numeroRevista, String uf) throws JAXBException, IOException {
        return buscarRevista(numeroRevista).getProcesso().stream()
            .filter(processo -> Objects.nonNull(processo.getTitulares()))
            .filter(processo -> processo.getTitulares().getTitular().getUf().equalsIgnoreCase(uf))
            .collect(Collectors.toList());
    }

    private Revista buscarRevista(String numeroRevista) throws JAXBException, IOException {
        dowloadFile(numeroRevista);
        unzipFile(numeroRevista);
        File file = new File("C:\\Users\\ander\\Desktop\\revistaInpi\\" + numeroRevista + ".xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Revista.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Revista) unmarshaller.unmarshal(file);
    }





}
