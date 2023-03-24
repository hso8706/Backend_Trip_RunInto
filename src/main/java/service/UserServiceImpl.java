package service;

import sample.model.dao.UserDAO;
import sample.model.dao.UserDAOImpl;
import sample.vo.User;

public class UserServiceImpl implements UserService {
    UserDAO dao;
    public UserServiceImpl() {
        dao = new UserDAOImpl();
    }

    @Override
    public boolean check(User user) {
        return dao.check(user);
    }
}
