package com.emergentes.dao;

import com.emergentes.controlador.Estudiante;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimp extends ConexionBD implements EstudianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        String sql = "Insert into estudiante(nombres,apellidos,seminario,confirmado,fecha_ins) values(?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminario());
        ps.setInt(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_ins());
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        String sql = "update estudiante set nombres=?,apellidos=?,seminario=?,confirmado=?,fecha_ins=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getApellidos());
        ps.setString(3, estudiante.getSeminario());
        ps.setInt(4, estudiante.getConfirmado());
        ps.setString(5, estudiante.getFecha_ins());
        ps.setInt(6, estudiante.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from estudiante where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Estudiante> getAll() throws Exception {

        List<Estudiante> lista = null;
        String sql = "select * from estudiante";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Estudiante>();
        while (rs.next()) {
            Estudiante est = new Estudiante();

            est.setId(rs.getInt("int"));
            est.setNombres(rs.getString("nombres"));
            est.setApellidos(rs.getString("apellidos"));
            est.setSeminario(rs.getString("seminario"));
            est.setConfirmado(rs.getInt("confirmado"));
            est.setFecha_ins(rs.getString("fecha_ins"));
            lista.add(est);

        }
        
        this.desconectar();
        return lista;
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        Estudiante est= new Estudiante();
        String sql = "select * from estudiante where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            est.setId(rs.getInt("int"));
            est.setNombres(rs.getString("nombres"));
            est.setApellidos(rs.getString("apellidos"));
            est.setSeminario(rs.getString("seminario"));
            est.setConfirmado(rs.getInt("confirmado"));
            est.setFecha_ins(rs.getString("fecha_ins"));
            

        }
        this.desconectar();
        return est;
        
    }

}
