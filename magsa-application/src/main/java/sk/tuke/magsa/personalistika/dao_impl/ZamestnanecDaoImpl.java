package sk.tuke.magsa.personalistika.dao_impl;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import sk.tuke.magsa.framework.CRUDDaoImpl;
import sk.tuke.magsa.framework.ValidatorException;
import sk.tuke.magsa.framework.ConnectionPool;
import sk.tuke.magsa.personalistika.entity.Zamestnanec;
import sk.tuke.magsa.personalistika.dao.ZamestnanecDao;

public class ZamestnanecDaoImpl extends CRUDDaoImpl<Zamestnanec> implements ZamestnanecDao {



    public ZamestnanecDaoImpl(ConnectionPool pool) {
        super(pool);
    }    

    protected PreparedStatement prepareInsertStatement(Connection connection, Zamestnanec object) throws SQLException {
        String query = "INSERT INTO Zamestnanec (meno, priezvisko, vek, ident_Oddelenie) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, object.getMeno());
        pstm.setString(2, object.getPriezvisko());
        pstm.setInt(3, object.getVek());

pstm.setInt(4, object.getOddelenie());

        return pstm;
    }

   protected PreparedStatement prepareUpdateStatement(Connection connection, Zamestnanec object) throws SQLException {
                String query = "UPDATE Zamestnanec SET meno=?,priezvisko=?,vek=? WHERE ident =" + object.getIdent();
    
  PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);  
        pstm.setString(1, object.getMeno());
        pstm.setString(2, object.getPriezvisko());
        pstm.setInt(3, object.getVek());

pstm.setInt(4, object.getOddelenie());
return pstm;
}

    protected PreparedStatement prepareDeleteStatement(Connection connection, Zamestnanec object) throws SQLException {
        String query = "DELETE FROM Zamestnanec WHERE ident =" + object.getIdent();

        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);      
        return pstm;
    }

    protected PreparedStatement prepareFindStatement(Connection connection, Integer id) throws SQLException {
        String query = "SELECT * FROM Zamestnanec WHERE ident="+id;
PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);      

        return pstm;
    }

    protected PreparedStatement prepareSelectStatement(Connection connection) throws SQLException {
         String query = "SELECT * FROM Zamestnanec";
PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);      

        return pstm;
    }

    protected Zamestnanec createFromResultSet(ResultSet rs) throws SQLException {
        Zamestnanec result = new Zamestnanec();
        result.setIdent(rs.getInt("ident"));
        result.setMeno(rs.getString("meno"));
        result.setPriezvisko(rs.getString("priezvisko"));
        result.setVek(rs.getInt("vek"));
        result.setOddelenie(rs.getInt("Oddelenie"));
return result;
    }

    @Override
    protected void test(Zamestnanec object) {
            
if(object.getMeno() == null)
{
    throw new ValidatorException ("This property must be define: meno");
}        if(object.getMeno() != null)
{
    if(object.getMeno().length() > 2 &&
        object.getMeno().length() < 30 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length meno: value must be from 2 to 30");
    }
}

   
                 
if(object.getPriezvisko() == null)
{
    throw new ValidatorException ("This property must be define: priezvisko");
}        if(object.getPriezvisko() != null)
{
    if(object.getPriezvisko().length() > 2 &&
        object.getPriezvisko().length() < 30 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length priezvisko: value must be from 2 to 30");
    }
}

   
                     }

}
