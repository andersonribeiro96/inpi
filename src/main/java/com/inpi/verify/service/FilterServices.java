package com.inpi.verify.service;

import com.inpi.verify.domain.revista.Processo;
import com.inpi.verify.domain.revista.Revista;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
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

    public List<Processo> processamento(List<String> processos) throws JAXBException, IOException {
        return buscarRevista("23").getProcesso().stream()
            .filter(processo -> processos.contains(processo.getNumero())).collect(Collectors.toList());
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
        File file = new File("target\\" + numeroRevista + ".xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Revista.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (Revista) unmarshaller.unmarshal(file);
    }





}
