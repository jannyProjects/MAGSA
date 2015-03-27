package sk.tuke.magsa.framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class CRUDDaoImpl<T extends Entity> implements CRUDDao<T> {
    protected final ConnectionPool pool;

    public CRUDDaoImpl(ConnectionPool pool) {
        this.pool = pool;
    }

    public ConnectionPool getPool() {
        return pool;
    }

    public void create(T object) {
        test(object);

        Connection connection = null;
        try {
            connection = pool.acquire();
            PreparedStatement pstm = prepareInsertStatement(connection, object);
            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            object.setIdent(rs.getInt(1));
            pstm.close();
            pool.release(connection);
        } catch (SQLException e) {
            pool.error(connection);
            throw new ApplicationException(11, "Cannot insert object to database", e);
        }
    }

    public void edit(T object) {
        test(object);

        Connection connection = null;
        try {
            connection = pool.acquire();
            PreparedStatement pstm = prepareUpdateStatement(connection, object);
            pstm.executeUpdate();
            pstm.close();
            pool.release(connection);
        } catch (SQLException e) {
            pool.error(connection);
            throw new ApplicationException(12, "Cannot update object in database", e);
        }
    }

    public void remove(T object) {
        test(object);

        Connection connection = null;
        try {
            connection = pool.acquire();
            PreparedStatement pstm = prepareDeleteStatement(connection, object);
            pstm.executeUpdate();
            pstm.close();
            pool.release(connection);
        } catch (SQLException e) {
            pool.error(connection);
            throw new ApplicationException(13, "Cannot remove object from database", e);
        }
    }

    public T find(Integer id) {
        Connection connection = null;
        try {
            T result = null;
            connection = pool.acquire();
            PreparedStatement pstm = prepareFindStatement(connection, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                result = createFromResultSet(rs);
            }
            pool.release(connection);
            return result;
        } catch (SQLException e) {
            pool.error(connection);
            throw new ApplicationException(14, "Cannot select object from database", e);
        }
    }

    public List<T> selectAll() {
        Connection connection = null;
        try {
            List<T> result = new ArrayList<T>();
            connection = pool.acquire();
            PreparedStatement pstm = prepareSelectStatement(connection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                result.add(createFromResultSet(rs));
            }
            pool.release(connection);
            return result;
        } catch (SQLException e) {
            pool.error(connection);
            throw new ApplicationException(15, "Cannot select object from database", e);
        }
    }

    protected abstract void test(T object);

    protected abstract PreparedStatement prepareInsertStatement(Connection connection, T object) throws SQLException;

    protected abstract PreparedStatement prepareUpdateStatement(Connection connection, T object) throws SQLException;

    protected abstract PreparedStatement prepareDeleteStatement(Connection connection, T object) throws SQLException;

    protected abstract PreparedStatement prepareFindStatement(Connection connection, Integer id) throws SQLException;

    protected abstract PreparedStatement prepareSelectStatement(Connection connection) throws SQLException;

    protected abstract T createFromResultSet(ResultSet rs) throws SQLException;
}
