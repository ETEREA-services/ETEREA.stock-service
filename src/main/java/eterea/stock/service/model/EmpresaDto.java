package eterea.stock.service.model;

import lombok.Data;

@Data
public class EmpresaDto {

    private Integer empresaId;
    private Integer negocioId;
    private String razonSocial;
    private String nombreFantasia;
    private String domicilio;
    private String telefono;
    private String cuit;
    private String ingresosBrutos;
    private String numeroEstablecimiento;
    private String sedeTimbrado;
    private String inicioActividades;
    private String condicionIva;
    private Byte unidadNegocio;
    private Integer diaInicial;
    private Integer negocioIdComision;
    private Byte conectaUnificado;
    private String certificado;

}
