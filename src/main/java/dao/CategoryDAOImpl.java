package dao;

import util.DBUtil;
import vo.AttractionInfo;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDAOImpl implements CategoryDAO {
    DBUtil util;

    public CategoryDAOImpl() {
        util = DBUtil.getInstance();
    }

    @Override
    public ArrayList<AttractionInfo> selectCategory(String categoryNum) {
        ArrayList<AttractionInfo> infoList = new ArrayList<>();
        try {
            Connection con = util.getConnection();
            String q = "select first_image, title, content_type_id, sido_code, gugun_code, addr1 from attraction_info where content_type_id = ? limit 10";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, categoryNum);
//            Statement stat = con.createStatement();
//            String q = "select first_image, title, content_type_id, sido_code, gugun_code, addr1 from attraction_info where content_type_id = 12 limit 10";
//            ResultSet rs = stat.executeQuery(q);
            ResultSet rs = stat.executeQuery();

            while(rs.next()){
                String first_image = rs.getString(1);
                String title = rs.getString(2);
                String content_type_id = rs.getString(3);
                String sido_code = rs.getString(4);
                String gugun_code = rs.getString(5);
                String addr1 = rs.getString(6);
//                System.out.println(title);

                AttractionInfo info = new AttractionInfo(null, content_type_id, title, addr1, null, null, null, first_image, null, null, sido_code, gugun_code, null, null, null);
                infoList.add(info);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return infoList;
    }
}
