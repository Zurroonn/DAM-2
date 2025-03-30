/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exameninterfacesalejandrozurron;

/**
 *
 * @author Manana
 */
public class Libro {

    String ISBN,titulo,autor,editorial,genero,formato;
    int año;
    public Libro(String ISBN, int año, String titulo, String autor, String editorial, String genero, String formato) {
        this.ISBN = ISBN;
        this.año = año;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.formato = formato;
    }

    @Override
    public String toString() {
        return java.util.ResourceBundle.getBundle("exameninterfacesalejandrozurron/Bundle").getString("LIBRO:")+autor+java.util.ResourceBundle.getBundle("exameninterfacesalejandrozurron/Bundle").getString("(")+año+java.util.ResourceBundle.getBundle("exameninterfacesalejandrozurron/Bundle").getString(")")+java.util.ResourceBundle.getBundle("exameninterfacesalejandrozurron/Bundle").getString(".")+titulo+java.util.ResourceBundle.getBundle("exameninterfacesalejandrozurron/Bundle").getString(".")+editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
}
