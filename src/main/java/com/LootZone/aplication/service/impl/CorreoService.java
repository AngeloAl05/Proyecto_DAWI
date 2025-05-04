package com.LootZone.aplication.service.impl;

import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
@Transactional
public class CorreoService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    PdfFacturasService pdfFacturasService;
    @Value("${spring.mail.username}")
    private String correo;

    public void mandarCorreo(String correoUsuario, Long id){
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper h = new MimeMessageHelper(mensaje,true);
            File file = pdfFacturasService.generarPDF(id);
            h.setFrom(correo);
            h.setTo(correoUsuario);
            h.setSubject("Factura");
            h.setText("Se a generado la factura de su compra");
            h.addAttachment("Factura",file);
            javaMailSender.send(mensaje);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
