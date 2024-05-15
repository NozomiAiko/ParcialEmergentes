
package com.emergentes.controlador;

public class Estudiante {
    private int id;
    private String nombres;
    private String apellidos;
    private String seminario;
    private int confirmado;
    private String fecha_ins;

    public Estudiante() {
        id = 0;
        nombres = "";
        apellidos = "";
        seminario = "";
        confirmado = 0;
        fecha_ins = "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    

    public String getFecha_ins() {
        return fecha_ins;
    }

    public void setFecha_ins(String fecha_ins) {
        this.fecha_ins = fecha_ins;
    }
    
}
