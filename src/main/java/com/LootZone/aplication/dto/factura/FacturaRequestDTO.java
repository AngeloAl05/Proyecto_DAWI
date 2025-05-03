package com.LootZone.aplication.dto.factura;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FacturaRequestDTO {
    private LocalDate fecha;
    private double total;
}
