package DAOS;


import DAO.MYSQL.DAOException;
import jugadores_equipos.Jugador;

import java.util.List;

//a este DAO genérico le entran dos parametros o objetos con los que trabajar, la clase generica y el id(el tipo de datos de la clase primaria)
//sacado de makigas https://www.youtube.com/watch?v=NjY-WA-jeJ8&list=PLTd5ehIj0goMKGkcD6cB7enP0nnyYiEzw&index=12
public interface DAO<ClaseGenerica, IDGenerico> {

    void insertarElemento(ClaseGenerica objetoParaInsertar) throws DAOException;

    void eliminarElemento(ClaseGenerica objetoParaInsertar) throws DAOException;

    void modificarElemento(ClaseGenerica objetoParaInsertar) throws DAOException;

    List<ClaseGenerica> obtenerObjetos() throws DAOException;

    ClaseGenerica obtenerElementoPorID(IDGenerico id) throws DAOException;

}
