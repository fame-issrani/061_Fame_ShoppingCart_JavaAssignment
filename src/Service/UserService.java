package Service;

import DAO.DaoInterfaces.UserDaoInterface;
import DAO.UserDaoImpl;
import Domain.User;

import java.util.List;

/**
 * Created by fame.issrani on 2/18/17.
 */
public class UserService {

UserDaoInterface userDaoInterface;

public UserService() {
	this.userDaoInterface=new UserDaoImpl();
}

public void insertuser(String name, String address, String email)throws Exception{
	User user=new User(name,address,email);
	try {
		userDaoInterface.save(user);
	} catch (Exception e) {
		throw e;
	}
}

public List<User> getAllUsers(){
	return userDaoInterface.getAllUsers();
}

public User getUser(int userId){
return userDaoInterface.getUserForId(userId);
}

public void deleteUser(int userId) throws Exception {
	userDaoInterface.removeUser(userId);
}

public User updateUser(int userId, User user){

	return null;
}

}
