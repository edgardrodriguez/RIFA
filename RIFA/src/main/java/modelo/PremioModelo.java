/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pablo Canales
 */
public class PremioModelo {
    private int cod;
    private String name;
    private String desc;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PremioModelo(int cod, String name, String desc) {
        this.cod = cod;
        this.name = name;
        this.desc = desc;
    }

    public PremioModelo() {
    }

    @Override
    public String toString() {
        return "PremioModelo{" + "cod=" + cod + ", name=" + name + ", desc=" + desc + '}';
    }
}
