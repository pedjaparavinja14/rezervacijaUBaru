/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;


import domain.DomainObject;
import domain.Korisnik;
import domain.Rezervacija;
import java.sql.Connection;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class DatabaseBroker {
    
    private final Connection connection;

    public DatabaseBroker(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public DomainObject login(DomainObject domainObject) throws SQLException {
         try {
           
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName() + " WHERE " + domainObject.getParamsForSelect1();
            System.out.println("Upit: " + query);

            
            PreparedStatement statement = connection.prepareStatement(query);
            domainObject.setParamsForSelect(statement, domainObject);

            
            ResultSet rs = statement.executeQuery();
            DomainObject domainObject1 = domainObject.getParamsForSelect2(rs, domainObject);

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekta ZaposleniUBaru iz baze!");
            return domainObject1;
        } catch (SQLException ex) {
            System.out.println("Objekat ZaposleniUBaru nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> getAll(DomainObject domainObject) throws Exception{
        try {
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName();
            System.out.println("Upit: " + query);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            List<DomainObject> list = domainObject.getParamsForSelect(rs);

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata iz baze!");
            return list;
        } catch (SQLException ex) {
            System.out.println("Objekti nisu uspesno ucitani iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean add(DomainObject domainObject) throws SQLException {
        try {

            String query = "INSERT INTO " + domainObject.getTableName() + " (" + domainObject.getColumnsForInsert() + ") VALUES (" + domainObject.getParamsForInsert()+")";

            System.out.println("Upit: " + query);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            domainObject.setParamsForInsert(statement, domainObject);

            int res = statement.executeUpdate();
            if (res > 0) {
                ResultSet rsID = statement.getGeneratedKeys();
                if (rsID.next()) {
                    domainObject.setAutoIncrementPrimaryKey(rsID.getLong(1));
                }
                rsID.close();
                statement.close();
                return true;
            } else {
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> search(DomainObject domainObject) throws Exception {
        try {
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName() + " WHERE " + domainObject.getReqForSearch()+ " LIKE ?";
            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query);

            domainObject.setParamsForSearch(statement, domainObject);

            ResultSet rs = statement.executeQuery();

            List<DomainObject> list = domainObject.getParamsForSelect(rs);

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata iz baze!");
            return list;
        } catch(SQLException e){
            System.out.println("Objekti nisu upsesno ucitani iz baze");
            e.printStackTrace();
            throw e;
        }
}

    public void delete(DomainObject domainObject) throws SQLException{
         try {
            String query = "DELETE FROM " + domainObject.getTableName() + " " + domainObject.getParamsForDelete();

            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            domainObject.setParamsForDelete(statement, domainObject);

            int result = statement.executeUpdate();
            System.out.println("Objekat uspesno obrisan iz baze!");

            statement.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno izbacivanje objekta iz baze!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
        
    }

    public boolean update(DomainObject domainObject) throws SQLException {
        try {
            String query = "UPDATE " + domainObject.getTableName() + " SET " + domainObject.getParamsForUpdate();

            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            domainObject.setParamsForUpdate(statement, domainObject);

            int result = statement.executeUpdate();

            System.out.println("Objekat uspesno izmenjen u bazi!");

            if (result > 0) {
                ResultSet rsID = statement.getGeneratedKeys();
                if (rsID.next()) {
                    domainObject.setAutoIncrementPrimaryKey(rsID.getInt(1));
                }
                rsID.close();
                statement.close();
                return true;
            } else {
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> getAllWithDoubleInnerJoin(DomainObject domainObject) throws Exception{
        try {
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName2() + " INNER JOIN " + domainObject.getInnerJoin1()+ " INNER JOIN "+domainObject.getInnerJoin2();
            System.out.println("Upit: " + query);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            List<DomainObject> list = domainObject.getParamsForSelect(rs);

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata iz baze!");
            return list;
        } catch (SQLException ex) {
            System.out.println("Objekti nisu uspesno ucitani iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }

    public List<DomainObject> searchWithDoubleInnerJoin(DomainObject domainObject) throws Exception{
        try {
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName2()+" INNER JOIN "+domainObject.getInnerJoin1()+ " INNER JOIN "+domainObject.getInnerJoin2() + " WHERE " + domainObject.getReqForSearch()+ " LIKE ?";
            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query);

            domainObject.setParamsForSearch(statement, domainObject);

            ResultSet rs = statement.executeQuery();

            List<DomainObject> list = domainObject.getParamsForSelect(rs);

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata iz baze!");
            return list;
        } catch(SQLException e){
            System.out.println("Objekti nisu upsesno ucitani iz baze");
            e.printStackTrace();
            throw e;
        }
    }

    public List<DomainObject> searchWithInnerJoin(DomainObject domainObject) throws Exception {
        try {
            String query = "SELECT " + domainObject.getColumnsForSelect() + " FROM " + domainObject.getTableName2()+" INNER JOIN "+domainObject.getInnerJoin1()+ " WHERE " + domainObject.getReqForSearch()+ " LIKE ?";
            System.out.println("Upit: " + query);

            PreparedStatement statement = connection.prepareStatement(query);

            domainObject.setParamsForSearch(statement, domainObject);

            ResultSet rs = statement.executeQuery();

            List<DomainObject> list = domainObject.getParamsForSelect(rs);

            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekata iz baze!");
            return list;
        } catch(SQLException e){
            System.out.println("Objekti nisu upsesno ucitani iz baze");
            e.printStackTrace();
            throw e;
        }
    }

   
    
}
