package dao;

import util.DBUtil;
import vo.AttractionInfo;

import java.sql.*;
import java.util.ArrayList;

public class AttractionInfoDAOImpl implements AttractionInfoDAO {

    private DBUtil util;
    public AttractionInfoDAOImpl() {
        util = DBUtil.getInstance();
    }
    @Override
    public ArrayList<AttractionInfo> selectAll() {
        return null;
    }

    @Override
    public AttractionInfo selectOne(String contentId) {
        return null;
    }

    @Override
    public ArrayList<String> selectSido() throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        Connection con = util.getConnection();
        Statement stat = con.createStatement();
        String q = "select sido_name from sido order by sido_code";
        ResultSet rs = stat.executeQuery(q);
        while (rs.next()) {
            String sidoName = rs.getString(1);
            list.add(sidoName);
        }
        return list;
    }

    @Override
    public ArrayList<String> selectGugun(String sidoCode) throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        Connection con = util.getConnection();

        String q = "select gugun_name from gugun where sido_code = ? order by gugun_code";
        PreparedStatement stat = con.prepareStatement(q);
        stat.setString(1, sidoCode);
        ResultSet rs = stat.executeQuery(q);

        while (rs.next()) {
            String gugunName = rs.getString(1);
            list.add(gugunName);
        }
        return list;
    }

    @Override
    public int insert(AttractionInfo attractionInfo) {
        return 0;
    }

    @Override
    public int delete(String contentId) {
        return 0;
    }
}
