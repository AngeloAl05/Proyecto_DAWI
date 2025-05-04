package com.LootZone.web.controller;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.service.impl.CorreoService;
import com.LootZone.aplication.service.impl.FacturaServiceImpl;

import com.LootZone.aplication.service.impl.PdfFacturasService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/factura")
public class FacturaController {
    private final FacturaServiceImpl service;
    private final PdfFacturasService PdfFacturasService;
    private final CorreoService correoService;

    @GetMapping
    public List<FacturaResponseDTO> listar(Authentication authentication) {
        String username = authentication.getName();
        return service.listar(username);
    }

    @PostMapping
    public FacturaResponseDTO crear(Authentication authentication,
                                    @RequestBody FacturaRequestDTO requestDTO) {
        String username = authentication.getName();
        return service.crear(username, requestDTO);
    }

    @GetMapping("/{id}")
    public FacturaResponseDTO buscarXID(@PathVariable Long id){
        return service.buscarXID(id);
    }

    @GetMapping("/pdf/{id}")
    public void GenerarPDF(HttpServletResponse response, @PathVariable Long id){
        try
        {
            Path file = Paths.get(PdfFacturasService.generarPDF(id).getAbsolutePath());
            if (Files.exists(file)){
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename"+ file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/enviarPdf/{correo}/{id}")
    public void enviarCorreo(@PathVariable String correo,@PathVariable Long id ){
        this.correoService.mandarCorreo(correo, id);
    }

}

