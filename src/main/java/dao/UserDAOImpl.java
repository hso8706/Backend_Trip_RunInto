package dao;

import sample.util.DBUtil;
import sample.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private DBUtil util;
    public UserDAOImpl() {
        util = DBUtil.getInstance();
    }
    @Override
    public boolean check(User user) {
        try {
            Connection con = util.getConnection();
            String q = "select pw from user where id = ? ";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, user.getId());
            ResultSet rs = stat.executeQuery();
            String pw = null;
            if (rs.next()) {
                pw = rs.getString(1);
            }
            con.close();
            if (pw.equals(user.getPw())) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
