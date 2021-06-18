package bip.processardados.com.br.service.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bip.processardados.com.br.gateway.repository.VendaRepository;

@Service
public class UpdateVendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Transactional
    public void execute() {
        vendaRepository.updateNameVendedor();
    }
}
