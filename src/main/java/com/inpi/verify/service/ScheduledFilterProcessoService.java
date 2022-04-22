package com.inpi.verify.service;

import com.inpi.verify.domain.Processo;
import com.inpi.verify.repository.ProcessoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableScheduling
public class ScheduledFilterProcessoService {

    @Autowired
    private FilterServices filterServices;

    @Autowired
    private ProcessoEntityRepository processoEntityRepository;

//    @Scheduled(cron = "${spring.cron.scheluded}", zone = "${spring.cron.zone}")
//    public void scheduledProcess() throws JAXBException, IOException {
//        List<Processo> processos = processoEntityRepository.findAll();
//        List<String> numeroProcessos = processos.stream().map(Processo::getNumeroProcesso).collect(Collectors.toList());
//        filterServices.processamento(numeroProcessos);
//    }



}
