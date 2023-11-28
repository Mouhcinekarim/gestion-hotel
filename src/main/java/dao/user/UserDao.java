package dao.user;

import beans.User;

public interface UserDao {
	void ajouter( User user );
	User connexion(String email,String password  );
}
