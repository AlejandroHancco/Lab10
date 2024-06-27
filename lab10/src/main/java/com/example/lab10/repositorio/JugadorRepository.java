package com.example.lab10.repositorio;

import com.example.lab10.entidad.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JugadorRepository extends DaoBase {


    public ArrayList<Jugador> listarJugador(){
        ArrayList<Jugador> lista = new ArrayList<>();
        String sql = "SELECT * FROM jugador";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setIdJugadores(rs.getInt("idJugador"));
                jugador.setNombre(rs.getString("nombre"));
                jugador.setEdad(rs.getInt("edad"));
                jugador.setPosicion(rs.getString("posicion"));
                jugador.setClub(rs.getString("club"));
                jugador.setSn_idSeleccion(rs.getInt("sn_idSeleccion"));
                lista.add(jugador);
            }

        }catch (SQLException e){throw new RuntimeException(e);}


        return lista;

    }



    public void crearJugador(Jugador jugador){
        String sql = "insert into jugador (idJugador,nombre,edad, posicion, club, sn_idSeleccion) values (?,?,?,?,?,?)";
        try (Connection conn =this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, jugador.getIdJugadores());
            pstmt.setString(2, jugador.getNombre());
            pstmt.setInt(3, jugador.getEdad());
            pstmt.setString(4, jugador.getPosicion());
            pstmt.setString(5, jugador.getClub());
            pstmt.setInt(6, jugador.getSn_idSeleccion());
            pstmt.executeUpdate();

        }catch(SQLException e){throw new RuntimeException(e);}

    }
    public Jugador buscarporId(int id){
        Jugador jugador = null;
        String sql = "select * from jugador where idJugador = ?";
        try (Connection conn =this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, id);

            try(ResultSet rs = pstmt.executeQuery()){

                while (rs.next()) {
                    jugador = new Jugador();
                    jugador.setIdJugadores(rs.getInt("idJugador"));
                    jugador.setNombre(rs.getString("nombre"));
                    jugador.setEdad(rs.getInt("edad"));
                    jugador.setPosicion(rs.getString("posicion"));
                    jugador.setClub(rs.getString("club"));
                    jugador.setSn_idSeleccion(rs.getInt("sn_idSeleccion"));

                }
            }
        }catch(SQLException e){throw new RuntimeException(e);
        }
        return jugador;
    }

    public void borrarJugador(int id){
        String sql = "delete from jugador where idJugador = ?";
        try (Connection conn =this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1,id);
            pstmt.executeUpdate();

        }catch(SQLException e){throw new RuntimeException(e);}

    }


}
