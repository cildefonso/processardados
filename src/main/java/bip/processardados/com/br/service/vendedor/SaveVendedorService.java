package bip.processardados.com.br.service.vendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bip.processardados.com.br.domain.Vendedor;
import bip.processardados.com.br.gateway.repository.VendedorRepository;

@Service
public class SaveVendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Transactional
    public void execute(Vendedor vendedor) {
        Vendedor vendedorDb = vendedorRepository.getByCpf(vendedor.getCpf());

        if (vendedorDb == null) {
            vendedorRepository.save(vendedor);
        } else {
            vendedorDb.setNome(vendedor.getNome());
            vendedorDb.setCpf(vendedor.getCpf());
            vendedorDb.setMeta(vendedor.getMeta());
            vendedorRepository.save(vendedorDb);
        }
    }
}
