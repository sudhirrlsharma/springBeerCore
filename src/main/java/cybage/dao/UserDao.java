package cybage.dao;


import cybage.spring.model.User;

public interface UserDao {

	User findByUserName(String username);
}

