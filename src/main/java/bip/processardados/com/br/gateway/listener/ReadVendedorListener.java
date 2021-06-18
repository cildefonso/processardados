package bip.processardados.com.br.gateway.listener;

import com.google.gson.Gson;

import bip.processardados.com.br.domain.Vendedor;
import bip.processardados.com.br.gateway.json.VendedorJson;
import bip.processardados.com.br.service.vendedor.SaveVendedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ReadVendedorListener {

    @Autowired
    private SaveVendedorService saveVendedorService;

    @KafkaListener(topics = "${kafka.topicgravardadoss1}", groupId = "${kafka.consumergroup}")
    public void execute(String message) throws IOException {
        VendedorJson vendedorJson = new Gson().fromJson(message, VendedorJson.class);
        saveVendedorService.execute(
                Vendedor
                        .builder()
                        .nome(vendedorJson.getNome())
                        .cpf(vendedorJson.getCpf())
                        .meta(vendedorJson.getMeta())
                        .build()
        );
    }

}
