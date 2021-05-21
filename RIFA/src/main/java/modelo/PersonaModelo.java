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
public class PersonaModelo {
    private int cod;
    private String name;
    private String lname;
    private String number;
    private String state;

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

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PersonaModelo() {
    }

    public PersonaModelo(int cod, String name, String lname, String number, String state) {
        this.cod = cod;
        this.name = name;
        this.lname = lname;
        this.number = number;
        this.state = state;
    }

    @Override
    public String toString() {
        return "PersonaModelo{" + "cod=" + cod + ", name=" + name + ", lname=" + lname + ", number=" + number + ", state=" + state + '}';
    }
}
