package sk.tuke.magsa.personalistika.dao_impl;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import sk.tuke.magsa.framework.CRUDDaoImpl;
import sk.tuke.magsa.framework.ValidatorException;
import sk.tuke.magsa.framework.ConnectionPool;
import sk.tuke.magsa.personalistika.entity.Oddelenie;
import sk.tuke.magsa.personalistika.dao.OddelenieDao;

public class OddelenieDaoImpl extends CRUDDaoImpl<Oddelenie> implements OddelenieDao {



    public OddelenieDaoImpl(ConnectionPool pool) {
        super(pool);
    }    

  protected PreparedStatement prepareInsertStatement(Connection connection, Oddelenie object) throws SQLException {
        String query = "INSERT INTO Oddelenie (nazov, kod, uroven) VALUES (?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, object.getNazov());
        pstm.setString(2, object.getKod());
        pstm.setDouble(3, object.getUroven());


        return pstm;
    }

   protected PreparedStatement prepareUpdateStatement(Connection connection, Oddelenie object) throws SQLException {
                String query = "UPDATE Oddelenie SET nazov=?,kod=?,uroven=?  WHERE ident =" + object.getIdent();
    
  PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);  
        pstm.setString(1, object.getNazov());
        pstm.setString(2, object.getKod());
        pstm.setDouble(3, object.getUroven());

return pstm;
}

    protected PreparedStatement prepareDeleteStatement(Connection connection, Oddelenie object) throws SQLException {
        String query = "DELETE FROM Oddelenie WHERE ident =" + object.getIdent();

        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);      
        return pstm;
    }

    protected PreparedStatement prepareFindStatement(Connection connection, Integer id) throws SQLException {
        String query = "SELECT * FROM Oddelenie WHERE ident="+id;
PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);      

        return pstm;
    }

    protected PreparedStatement prepareSelectStatement(Connection connection) throws SQLException {
         String query = "SELECT * FROM Oddelenie";
PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);      

        return pstm;
    }

    protected Oddelenie createFromResultSet(ResultSet rs) throws SQLException {
        Oddelenie result = new Oddelenie();
        result.setIdent(rs.getInt("ident"));
        result.setNazov(rs.getString("nazov"));
        result.setKod(rs.getString("kod"));
        result.setUroven(rs.getDouble("uroven"));
return result;
    }

    @Override
    protected void test(Oddelenie object) {
            
if(object.getNazov() == null)
{
    throw new ValidatorException ("This property must be define: nazov");
}        if(object.getNazov() != null)
{
    if(object.getNazov().length() > 5 &&
        object.getNazov().length() < 30 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length nazov: value must be from 5 to 30");
    }
}

   
                 
if(object.getKod() == null)
{
    throw new ValidatorException ("This property must be define: kod");
}        if(object.getKod() != null)
{
    if(object.getKod().length() > 1 &&
        object.getKod().length() < 4 )
    {        
    }
    else
    {
        throw new ValidatorException ("Wrong property length kod: value must be from 1 to 4");
    }
}

   
                     }

}
