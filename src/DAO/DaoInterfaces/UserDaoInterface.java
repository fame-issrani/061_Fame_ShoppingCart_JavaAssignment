package DAO.DaoInterfaces;

import Domain.User;

import java.util.List;

/**
 * Created by fame.issrani on 2/20/17.
 */
public interface UserDaoInterface {

void save(User user)throws Exception;

List<User> getAllUsers();

User getUserForId(int userId);

void removeUser(int userId)throws Exception;
}
