/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salti_dilfani.model;

/**
 *
 * @author salti
 */
public class Dosen 
{
    private String nidn;
    private String nama;
    private String jenisKelamin;
    private String tgllahir;
    
    public Dosen(){
    }

    public Dosen(String nidn, String nama, String jenisKelamin, String tgllahir) {
        this.nidn = nidn;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tgllahir = tgllahir;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }
}