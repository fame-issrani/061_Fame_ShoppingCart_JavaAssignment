package DAO;

/**
 * Created by fame.issrani on 2/16/17.
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.DaoInterfaces.UserDaoInterface;
import Domain.User;
import Exceptions.DataNotFound;

public class UserDaoImpl implements UserDaoInterface{

    public void save(User user) throws SQLException, ClassNotFoundException {

        Connection conn= DBConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("Insert into USER values (null,?,?,?)");
        pst.setString(1,user.getName());
        pst.setString(2,user.getAddress());
        pst.setString(3,user.getEmail());
        pst.execute();
        System.out.println("User Data has been saved to databse with primary Key :");
        conn.close();
    }

    public List<User> getAllUsers(){
        List<User> users=new ArrayList<User>();
        Connection conn= null;
        try {
            conn = DBConnection.getConnection();
            Statement stmt=conn.createStatement();
            String sql = "SELECT * FROM USER";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                int id = rs.getInt("USER_ID");
                String name= rs.getString("USER_NAME");
                String address = rs.getString("USER_ADDRESS");
                String email = rs.getString("USER_EMAIL");

                User user=new User(id,name,address,email);
                users.add(user);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserForId(int userId){

        User user=null;
        Connection conn= null;
        try {
            conn = DBConnection.getConnection();

			System.out.println("asdasdas");


            String sql = "SELECT * FROM USER WHERE USER_ID="+ userId ;
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            ResultSet rs = pst.executeQuery(sql);

			while(rs.next()){
				user=new User(rs.getInt("USER_ID"),rs.getString("USER_NAME"),rs.getString("USER_ADDRESS"),rs.getString("USER_EMAIL"));
			}
            rs.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;

    }

    public void removeUser(int userId)throws Exception{
        User user=getUserForId(userId);

        if(user == null){
            throw new DataNotFound("No User exists with userId: "+userId);
        }else{
            Connection conn= DBConnection.getConnection();
            String sql="Delete from USER where USER_ID= "+userId;
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.executeUpdate(sql);
            conn.close();
            System.out.println("User with USER_ID :"+userId+" has been removed successfully");
        }
    }


}
