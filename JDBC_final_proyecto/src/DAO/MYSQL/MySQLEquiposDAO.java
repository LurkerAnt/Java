package DAO.MYSQL;

import DAOS.EquiposDAO;
import jugadores_equipos.Equipo;
import jugadores_equipos.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLEquiposDAO implements EquiposDAO {

    private Connection conexion;
    final String INSERT = "INSERT INTO equipos(id_equipo, nombre_equipo, ciudad_equipo) VALUES(?,?,?)";
    final String UPDATE = "UPDATE equipos SET nombre_equipo = ?, ciudad_equipo = ? WHERE  id_equipo=?";
    final String DELETE = "DELETE FROM equipos WHERE id_equipo=?";
    //esto nos vale porque la base de datos es canija si fuera grande esto no se debe hacer y hay que poner delimitadores.
    final String GETALL = "SELECT id_equipo, nombre_equipo, ciudad_equipo from equipos";
    final String GETONE = "SELECT id_equipo, nombre_equipo, ciudad_equipo from equipos WHERE id_equipo=?";

    public MySQLEquiposDAO(Connection conexion) {
        this.conexion=conexion;
    }

    @Override
    public void insertarElemento(Equipo objetoParaInsertar) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            preparedStatement = conexion.prepareStatement(INSERT);
            preparedStatement.setInt(1, objetoParaInsertar.getIdEquipo());
            preparedStatement.setString(2, objetoParaInsertar.getNombreEquipo());
            preparedStatement.setString(3, objetoParaInsertar.getCiudadEquipo());
            if (preparedStatement.executeUpdate() == 0) {
                throw new DAOException("No se ha guardado, Prepared Statement falló.");
            }

            resultSet=preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                objetoParaInsertar.setIdEquipo(resultSet.getInt(1));
            }else {
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
    public void eliminarElemento(Equipo objetoParaInsertar) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement(DELETE);
            preparedStatement.setInt(1, objetoParaInsertar.getIdEquipo());
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
    public void modificarElemento(Equipo objetoParaInsertar) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement(UPDATE);
            preparedStatement.setString(1, objetoParaInsertar.getNombreEquipo());
            preparedStatement.setString(2, objetoParaInsertar.getCiudadEquipo());
            preparedStatement.setInt(3, objetoParaInsertar.getIdEquipo());
            if (preparedStatement.executeUpdate() == 0) {
                throw new DAOException("No se ha Modificado, Prepared Statement Falló.");

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
    public List<Equipo> obtenerObjetos() throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Equipo equipo = null;
        List<Equipo> listaEquipos = new ArrayList<>();
        try {
            preparedStatement = conexion.prepareStatement(GETALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                equipo = convertidDeSetAEquipo(resultSet);
                listaEquipos.add(equipo);
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
        return listaEquipos;
    }

    @Override
    public Equipo obtenerElementoPorID(Integer id) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Equipo equipo = null;
        try {
            preparedStatement = conexion.prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                equipo = convertidDeSetAEquipo(resultSet);
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
        return equipo;
    }

    public Equipo convertidDeSetAEquipo(ResultSet set) throws SQLException {

        int id = set.getInt("id_equipo");
        String nombre = set.getString("nombre_equipo");
        String ciudad = set.getString(("ciudad_equipo"));
        Equipo equipo = new Equipo(id, nombre, ciudad);
        return equipo;
    }

}
