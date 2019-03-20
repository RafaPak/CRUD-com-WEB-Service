package bd.daos;
import bd.*;
import bd.core.*;
import bd.dbos.Cinema;
import java.sql.SQLException;

public class Cinemas
{
    public static boolean cadastrado(int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM CINEMA " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar Cinema!");
        }

        return retorno;
    }

    public static void incluir(Cinema cine) throws Exception
    {
        if (cine == null)
            throw new Exception ("Cinema n�o fornecido!");

        try
        {
            String sql;

            sql = "INSERT INTO CINEMA " +
                  "(CODIGO, NOME, CEP, NUMERO, COMPLEMENTO) " +
                  "VALUES " +
                  "(?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt   (1, cine.getCod());
            BDSQLServer.COMANDO.setString(2, cine.getNome());
            BDSQLServer.COMANDO.setString(3, cine.getCEP());
            BDSQLServer.COMANDO.setString(4, cine.getNumero());
            BDSQLServer.COMANDO.setString(5, cine.getComplemento());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir Cinema!");
        }
    }

    public static void excluir(int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("N�o cadastrado!");

        try
        {
            String sql;

            sql = "DELETE FROM CINEMA " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();        
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir Cinema!");
        }
    }

    public static void alterar(Cinema cine) throws Exception
    {
        if (cine == null)
            throw new Exception ("Cinema n�o fornecido");

        if (!cadastrado (cine.getCod()))
            throw new Exception ("N�o cadastrado");

        try
        {
            String sql;

            sql = "UPDATE CINEMA " +
                  "SET NOME = ? " +
                  "SET CEP = ? " +
                  "SET NUMERO = ? " +
                  "SET COMPLEMENTO = ? " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString(1, cine.getNome());
            BDSQLServer.COMANDO.setString(2, cine.getCEP());
            BDSQLServer.COMANDO.setString(3, cine.getNumero());
            BDSQLServer.COMANDO.setString(4, cine.getComplemento());
            BDSQLServer.COMANDO.setInt   (5, cine.getCod());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de Cinema!");
        }
    }

    public static Cinema getCinema(int codigo) throws Exception
    {
        Cinema cine = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM CINEMA " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("N�o cadastrado!");

            cine = new Cinema(resultado.getInt   ("CODIGO"),
                              resultado.getString("NOME"),
                              resultado.getString("CEP"),
                              resultado.getString("NUMERO"),
                              resultado.getString("COMPLEMENTO"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar Cinema!");
        }

        return cine;
    }

    public static MeuResultSet getCinemas() throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM CINEMA";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar Cinemas!");
        }

        return resultado;
    }
}
