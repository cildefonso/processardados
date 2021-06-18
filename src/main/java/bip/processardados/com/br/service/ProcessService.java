package bip.processardados.com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import bip.processardados.com.br.service.email.EmailService;
import bip.processardados.com.br.service.pdf.GenerateReportService;
import bip.processardados.com.br.service.venda.UpdateVendaService;

import javax.mail.MessagingException;
import java.io.ByteArrayOutputStream;

@Service
public class ProcessService {

    @Autowired
    private UpdateVendaService updateVendaService;

    @Autowired
    private GenerateReportService generateReportService;

    @Autowired
    private EmailService emailService;

    @Scheduled(fixedRate = 60000)
    public void execute() throws MessagingException {

        updateVendaService.execute();

        ByteArrayOutputStream pdf = generateReportService.execute();

        emailService.execute(pdf);
    }

}
