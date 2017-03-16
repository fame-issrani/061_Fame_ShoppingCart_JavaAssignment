package Client;

import java.sql.SQLException;
import java.util.List;

import DAO.UserDaoImpl;
import Domain.User;
import Service.UserService;
import sun.util.resources.cldr.sv.CalendarData_sv_FI;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class UserClient {
    public static void main(String[] args)  {
        try {
			UserService userService=new UserService();

            // fetching all the User objects from a CSV file named as userCsv.csv

        List<User> users= CSVFileReader.readUserCSV();

            for(User user:users){
               userService.insertuser(user.getName(),user.getAddress(),user.getEmail());
            }

            //To get the list of all users
            List<User> list=userService.getAllUsers();
            for(User user:users){
                System.out.println(user.toString());
            }

			//To get a specific user for its userId
            User user=userService.getUser(1);
            System.out.println(user.toString());
            System.out.println("\n Data Retrieval Successfull");

			//To remove a specific user from the database
            userService.deleteUser(1);

        } catch (Exception e) {
			System.out.println(e.getMessage());
        }
    }

}
