package DAO.MYSQL;

import DAOS.JugadorDAO;
import conexion.ConexionBD;
import jugadores_equipos.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//basado en makigas https://www.youtube.com/watch?v=j8BgWo8USBA&list=PLTd5ehIj0goMKGkcD6cB7enP0nnyYiEzw&index=13
//codigo adaptado a mi BD

public class MySQLJugadorDAO implements JugadorDAO {

    private Connection conexion;
    final String INSERT = "INSERT INTO jugadores(nombre_jugador, id_equipo, posicion_jugador) VALUES(?,?,?)";
    final String UPDATE = "UPDATE jugadores SET nombre_jugador = ?, id_equipo = ?, posicion_jugador = ? WHERE  id_jugador=?";
    final String DELETE = "DELETE FROM jugadores WHERE id_jugador=?";
    //esto nos vale porque la base de datos es canija si fuera grande esto no se debe hacer y hay que poner delimitadores.
    final String GETALL = "SELECT id_jugador, nombre_jugador, id_equipo, posicion_jugador from jugadores";
    final String GETONE = "SELECT id_jugador, nombre_jugador, id_equipo, posicion_jugador from jugadores WHERE id_jugador=?";

    public MySQLJugadorDAO(Connection conexion) {
        this.conexion = conexion;
    }


    @Override
    public void insertarElemento(Jugador objetoParaInsertar) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //Return generated keys es porque así devuelve la key y la asigna. a makigas le funciona tal cual pero aqui ha pedido esto.
            preparedStatement = conexion.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objetoParaInsertar.getNombreJugador());
            preparedStatement.setInt(2, objetoParaInsertar.getIdEquipo());
            preparedStatement.setString(3, objetoParaInsertar.getPosicionJugador());
            if (preparedStatement.executeUpdate() == 0) {
                throw new DAOException("No se ha guardado, Prepared Statement falló.");
            }

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                objetoParaInsertar.setIdJugador(resultSet.getInt(1));
            } else {
                throw new DAOException("No se ha podido asigar ID al Jugador.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
        }


    }

    @Override
    public void eliminarElemento(Jugador objetoParaInsertar) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement(DELETE);
            preparedStatement.setInt(1, objetoParaInsertar.getIdJugador());
            if (preparedStatement.executeUpdate() == 0) {
                throw new DAOException("No se ha Borrado, Prepared Statement Falló.");

            }
        } catch (SQLException e) {
            throw new DAOException("Error en el SQL", e);
        } finally {
            if (preparedStatement != null) {

                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en el SQL", e);

                }
            }
        }
    }

    @Override
    public void modificarElemento(Jugador objetoParaInsertar) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement(UPDATE);
            preparedStatement.setString(1, objetoParaInsertar.getNombreJugador());
            preparedStatement.setInt(2, objetoParaInsertar.getIdEquipo());
            preparedStatement.setString(3, objetoParaInsertar.getPosicionJugador());
            preparedStatement.setInt(4, objetoParaInsertar.getIdJugador());
            if (preparedStatement.executeUpdate() == 0) {
                throw new DAOException("No se ha Borrado, Prepared Statement Falló.");

            }
        } catch (SQLException e) {
            throw new DAOException("Error en el SQL", e);
        } finally {
            if (preparedStatement != null) {

                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en el SQL", e);

                }
            }
        }
    }


    @Override
    public List<Jugador> obtenerObjetos() throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Jugador jugador = null;
        List<Jugador> listaJugadores = new ArrayList<>();
        try {
            preparedStatement = conexion.prepareStatement(GETALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jugador = convertidDeSetAJugador(resultSet);
                listaJugadores.add(jugador);
            }
        } catch (SQLException e) {
            throw new DAOException("Error en el SQL", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }

        }
        return listaJugadores;
    }

    @Override
    public Jugador obtenerElementoPorID(Integer id) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Jugador jugador = null;
        try {
            preparedStatement = conexion.prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                jugador = convertidDeSetAJugador(resultSet);
            } else {
                throw new DAOException("No se ha encontrado ese registro");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en el SQL", e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }

        }
        return jugador;
    }

    public Jugador convertidDeSetAJugador(ResultSet set) throws SQLException {

        int idJugador = set.getInt("id_jugador");
        String nombre = set.getString("nombre_jugador");
        int idEquipo = set.getInt("id_equipo");
        String posicionJugador = set.getString("posicion_jugador");

        Jugador jugador = new Jugador(idJugador, idEquipo, nombre, posicionJugador);


        return jugador;
    }

    public static void main(String[] args) throws DAOException, SQLException {
        Connection conexion = null;
        final String JDBC = "jdbc:mysql://localhost:3306/equipos";
        final String configUTF = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String USER = "userJDBC";
        final String PASSWORD = "12345";
        try {
            conexion = DriverManager.getConnection(JDBC+configUTF, USER, PASSWORD);
            JugadorDAO jugadorDAO = new MySQLJugadorDAO(conexion);
            List<Jugador> listaJugadores = jugadorDAO.obtenerObjetos();
            for (Jugador jugador : listaJugadores) {
                System.out.println(jugador);
            }
            Jugador jugadorNuevo = new Jugador(1, "Rafa nadal", "jungla");
            //jugadorDAO.insertarElemento(jugadorNuevo);
            //System.out.println("Se ha añadido el elemento con el id" +jugadorNuevo.getIdJugador());
            jugadorDAO.eliminarElemento(jugadorNuevo);


        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}


