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
    public ArrayList<String> selectGugun(String sidoName) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sidoCode = getSidoCode(sidoName);
            Connection con = util.getConnection();
            String q = "select gugun_name from gugun where sido_code = ? order by gugun_code";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, sidoCode);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String gugunName = rs.getString(1);
                list.add(gugunName);
            }
            System.out.println(list);
            con.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }

        return list;
    }

    @Override
    public ArrayList<AttractionInfo> search(String sidoName, String gugunName, String keyword) {
        ArrayList<AttractionInfo> list = new ArrayList<>();
        try {
            Connection con = util.getConnection();
            String sidoCode = getSidoCode(sidoName);
            String gugunCode = getGugunCode(sidoCode, gugunName);

            String q = "select * from attraction_info where sido_code = ? and gugun_code = ? and title like ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, sidoCode);
            stat.setString(2, gugunCode);
            stat.setString(3, "%" + keyword + "%");

            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                AttractionInfo info = new AttractionInfo();
                info.setContentId(rs.getString(1));
                info.setTitle(rs.getString(3));
                info.setAddr1(rs.getString(4));
                info.setAddr2(rs.getString(5));
                info.setFirstImage(rs.getString(8));
                info.setLatitude(rs.getString(13));
                info.setLongitude(rs.getString(14));
                list.add(info);
            }
            System.out.println(list);
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return list;
    }

    @Override
    public int insert(AttractionInfo attractionInfo) {
        return 0;
    }

    @Override
    public String getSidoCode(String sidoName) {
        String sidoCode = null;
        try {
            Connection con = util.getConnection();
            String q = "select sido_code from sido where sido_name = ";
            PreparedStatement stat = con.prepareStatement(q + "'" + sidoName + "'");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                sidoCode = rs.getString(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return sidoCode;
    }

    @Override
    public String getGugunCode(String sidoCode, String gugunName) {
        String gugunCode = null;
        try {
            Connection con = util.getConnection();
            String q = "select gugun_code from gugun where sido_code = ? and gugun_name = ";
            PreparedStatement stat = con.prepareStatement(q + "'" + gugunName + "'");
            stat.setString(1, sidoCode);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                gugunCode = rs.getString(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return gugunCode;
    }

    @Override
    public int delete(String contentId) {
        return 0;
    }
}
