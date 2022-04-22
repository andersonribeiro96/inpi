package com.inpi.verify.service;

import com.inpi.verify.domain.Processo;
import com.inpi.verify.repository.ProcessoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoEntityRepository processoEntityRepository;

    public Processo adicionarProcesso(Processo processo) {
        return processoEntityRepository.save(processo);
    }


}
