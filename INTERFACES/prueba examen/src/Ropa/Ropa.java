/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ropa;

import java.util.List;

/**
 *
 * @author Zurrón
 */
public class Ropa {
    String codigo,sexo;
    List<String>tallas;

    public Ropa() {
    }

    public Ropa(String codigo, String sexo, List<String> tallas) {
        this.codigo = codigo;
        this.sexo = sexo;
        this.tallas = tallas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<String> getTallas() {
        return tallas;
    }

    public void setTallas(List<String> tallas) {
        this.tallas = tallas;
    }

    @Override
    public String toString() {
        return "Ropa{" + "codigo=" + codigo + ", sexo=" + sexo + ", tallas=" + tallas + '}';
    }
    
    
}


