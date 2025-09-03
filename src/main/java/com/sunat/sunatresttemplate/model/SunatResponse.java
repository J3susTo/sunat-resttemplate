package com.sunat.sunatresttemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SunatResponse {
    @JsonProperty("ruc")
    private String ruc;

    @JsonProperty("razon_social")
    private String razonSocial;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("condicion")
    private String condicion;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("ubigeo")
    private String ubigeo;

    @JsonProperty("departamento")
    private String departamento;

    @JsonProperty("provincia")
    private String provincia;

    @JsonProperty("distrito")
    private String distrito;
}