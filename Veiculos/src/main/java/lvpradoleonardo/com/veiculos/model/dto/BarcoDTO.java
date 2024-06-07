package lvpradoleonardo.com.veiculos.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BarcoDTO {
    public Long id;
    private String marca;
    private String modelo;
    private boolean alto_mar;
    private float valor;

    public BarcoDTO(Long id, String marca, String modelo, boolean alto_mar, float valor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.alto_mar = alto_mar;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isAlto_mar() {
        return alto_mar;
    }

    public void setAlto_mar(boolean alto_mar) {
        this.alto_mar = alto_mar;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
