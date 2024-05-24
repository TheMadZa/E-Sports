package Controlador.ControladoresBD;

import java.sql.*;

/**
 * Clase ControladorXML que gestiona las operaciones relacionadas con XML en la base de datos.
 *
 * <p>Esta clase proporciona métodos para obtener XML con y sin validación de tipo DTD y XSD desde la base de datos.</p>
 *
 * @author Zahir
 * @version 1.0
 */
public class ControladorXML {
    private final Connection con;

    /**
     * Constructor de la clase ControladorXML.
     *
     * @param con La conexión a la base de datos.
     */
    public ControladorXML(Connection con) {
        this.con = con;
    }

    /**
     * Obtiene el XML de la clasificación con validación de tipo DTD.
     *
     * @return El XML de la clasificación con validación de tipo DTD.
     * @throws Exception Si ocurre un error durante la obtención del XML.
     */
    public String obtenerXMLClasificacionDTD() throws Exception {
        CallableStatement callableStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuilder result = new StringBuilder();

        try {
            // Llamar al procedimiento almacenado
            callableStatement = con.prepareCall("{call PAQUETE_XML.XML_CLASIFI_DTD}");
            callableStatement.execute();

            // Ejecutar la consulta SQL
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM XML_CLASIFICACION");

            // Procesar el resultado: Obtener la primera fila
            if (resultSet.next()) {
                String columna1 = resultSet.getString("result");
                result.append("resultado: ").append(columna1).append("\n");
            }
        } catch (SQLException e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }

        return result.toString();
    }

    /**
     * Obtiene el XML de la clasificación con validación de tipo XSD.
     *
     * @return El XML de la clasificación con validación de tipo XSD.
     * @throws Exception Si ocurre un error durante la obtención del XML.
     */
    public String obtenerXMLClasificacionXSD() throws Exception {
        CallableStatement callableStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuilder result = new StringBuilder();

        try {
            // Llamar al procedimiento almacenado
            callableStatement = con.prepareCall("{call PAQUETE_XML.XML_CLASIFI_XSD}");
            callableStatement.execute();

            // Ejecutar la consulta SQL
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM XML_CLASIFICACION");

            // Procesar el resultado: Obtener la segunda fila
            if (resultSet.next()) {
                // Saltar la primera fila
                resultSet.next();
                // Obtener la segunda fila
                String columna1 = resultSet.getString("result");
                result.append("resultado: ").append(columna1).append("\n");
            }
        } catch (SQLException e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }

        return result.toString();
    }

    /**
     * Obtiene el XML de las jornadas con validación de tipo DTD.
     *
     * @return El XML de las jornadas con validación de tipo DTD.
     * @throws Exception Si ocurre un error durante la obtención del XML.
     */
    public String obtenerXMLJornadasDTD() throws Exception {
        CallableStatement callableStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuilder result = new StringBuilder();

        try {
            // Llamar al procedimiento almacenado
            callableStatement = con.prepareCall("{call PAQUETE_XML.XML_JORNADAS_DTD}");
            callableStatement.execute();

            // Ejecutar la consulta SQL
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM XML_JORNADAS");

            // Procesar el resultado: Obtener la primera fila
            if (resultSet.next()) {
                String columna1 = resultSet.getString("result");
                result.append("resultado: ").append(columna1).append("\n");
            }
        } catch (SQLException e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }

        return result.toString();
    }

    /**
     * Obtiene el XML de las jornadas con validación de tipo XSD.
     *
     * @return El XML de las jornadas con validación de tipo XSD.
     * @throws Exception Si ocurre un error durante la obtención del XML.
     */
    public String obtenerXMLJornadasXSD() throws Exception {
        CallableStatement callableStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuilder result = new StringBuilder();

        try {
            // Llamar al procedimiento almacenado
            callableStatement = con.prepareCall("{call PAQUETE_XML.XML_JORNADAS_XSD}");
            callableStatement.execute();

            // Ejecutar la consulta SQL
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM XML_JORNADAS");

            // Procesar el resultado: Obtener la segunda fila
            if (resultSet.next()) {
                // Saltar la primera fila
                resultSet.next();
                // Obtener la segunda fila
                String columna1 = resultSet.getString("result");
                result.append("resultado: ").append(columna1).append("\n");
            }
        } catch (SQLException e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }

        return result.toString();
    }

    /**
     * Obtiene el XML de la última jornada con validación de tipo DTD.
     *
     * @return El XML de la última jornada con validación de tipo DTD.
     * @throws Exception Si ocurre un error durante la obtención del XML.
     */
    public String obtenerXMLUltimaJornadaDTD() throws Exception {
        CallableStatement callableStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuilder result = new StringBuilder();

        try {
            // Llamar al procedimiento almacenado
            callableStatement = con.prepareCall("{call PAQUETE_XML.XML_ULTIMA_JORNADA_DTD}");
            callableStatement.execute();

            // Ejecutar la consulta SQL
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM XML_ULTIMA_JORNADA");

            // Procesar el resultado: Obtener la primera fila
            if (resultSet.next()) {
                String columna1 = resultSet.getString("result");
                result.append("resultado: ").append(columna1).append("\n");
            }
        } catch (SQLException e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }

        return result.toString();
    }

    /**
     * Obtiene el XML de la última jornada con validación de tipo XSD.
     *
     * @return El XML de la última jornada con validación de tipo XSD.
     * @throws Exception Si ocurre un error durante la obtención del XML.
     */
    public String obtenerXMLUltimaJornadaXSD() throws Exception {
        CallableStatement callableStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuilder result = new StringBuilder();

        try {
            // Llamar al procedimiento almacenado
            callableStatement = con.prepareCall("{call PAQUETE_XML.XML_ULTIMA_JORNADA_XSD}");
            callableStatement.execute();

            // Ejecutar la consulta SQL
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM XML_ULTIMA_JORNADA");

            // Procesar el resultado: Obtener la segunda fila
            if (resultSet.next()) {
                // Saltar la primera fila
                resultSet.next();
                // Obtener la segunda fila
                String columna1 = resultSet.getString("result");
                result.append("resultado: ").append(columna1).append("\n");
            }
        } catch (SQLException e) {
            throw new Exception("Error: " + e.getMessage(), e);
        }

        return result.toString();
    }
}
