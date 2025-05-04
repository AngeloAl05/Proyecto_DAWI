package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.domain.entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.List;


@Service
public class PdfFacturasService {
    private static final String PDF = "/pdf-resources";
    private SpringTemplateEngine springTemplateEngine;
    private FacturaServiceImpl facturaService;

    @Autowired
    public PdfFacturasService(SpringTemplateEngine springTemplateEngine, FacturaServiceImpl facturaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.facturaService = facturaService;
    }
    private String convertirXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        tidy.setPrintBodyOnly(true);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setSmartIndent(true);
        tidy.setShowWarnings(false);
        tidy.setQuiet(true);
        tidy.setTidyMark(false);
        Document htmlDOM = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);
        OutputStream out = new ByteArrayOutputStream();
        tidy.pprint(htmlDOM, out);
        return out.toString();
    }
    private File renderFacturasPdf(String html) throws Exception {
        File file = File.createTempFile("facturas", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContextFacturasPDF(Long id){
        FacturaResponseDTO factura = this.facturaService.buscarXID(id);
        Context context = new Context();
        context.setVariable("factura",factura);
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return springTemplateEngine.process("facturaPDF", context);
    }

    public File generarPDF(Long id) throws Exception{
        Context context = getContextFacturasPDF(id);
        String html = loadAndFillTemplate(context);
        String xhtml = convertirXhtml(html);
        return renderFacturasPdf(xhtml);
    }
}
