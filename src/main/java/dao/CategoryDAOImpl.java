package dao;

import util.DBUtil;
import vo.AttractionInfo;
import vo.ContentDescription;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class CategoryDAOImpl implements CategoryDAO {
    DBUtil util;

    public CategoryDAOImpl() {
        util = DBUtil.getInstance();
    }

    @Override
    public ArrayList<AttractionInfo> selectCategory(String contentTypeId) {
        ArrayList<AttractionInfo> infoList = new ArrayList<>();
//        try {
//            Connection con = util.getConnection();
//            String q = "select content_id, first_image, title, content_type_id, sido_code, gugun_code, addr1, first_image2 from attraction_info where content_type_id = ? limit = 10";
//            PreparedStatement stat = con.prepareStatement(q);
//            stat.setString(1, contentTypeId);
//            ResultSet rs = stat.executeQuery();
//
//            while (rs.next()) {
//                String content_id = rs.getString(1);
//                String first_image = rs.getString(2);
//                String title = rs.getString(3);
//                String content_type_id = rs.getString(4);
//                String sido_code = rs.getString(5);
//                String gugun_code = rs.getString(6);
//                String addr1 = rs.getString(7);
//                String second_image = rs.getString(8);
//
//                AttractionInfo info = new AttractionInfo(content_id, content_type_id, title, addr1, null, null, null, first_image, second_image, null, sido_code, gugun_code, null, null, null);
//                infoList.add(info);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        return infoList;
    }

    @Override
    public ArrayList<AttractionInfo> searchCategory(Map<String, Object> param) {
        ArrayList<AttractionInfo> infoList = new ArrayList<>();
        try {
            //param_keys : "contentTypeId", "word", "start", "listsize"

            Connection con = util.getConnection();
            String q = "select content_id, first_image, title, content_type_id, sido_code, gugun_code, addr1, first_image2 from attraction_info where content_type_id = ?";
            PreparedStatement stat;

            if(param.get("word") != null){
                q += " and title like concat('%', ?, '%') order by content_id desc limit ?, ?";
                stat = con.prepareStatement(q);
                stat.setString(1, (String) param.get("contentTypeId"));
                stat.setString(2, (String) param.get("word"));
                stat.setInt(3, (Integer) param.get("start"));
                stat.setInt(4, (Integer) param.get("listsize"));

            }
            else{
                q += " order by content_id desc limit ?, ?";
                stat = con.prepareStatement(q);
                stat.setString(1, (String) param.get("contentTypeId"));
                stat.setInt(2, (Integer) param.get("start"));
                stat.setInt(3, (Integer) param.get("listsize"));
            }

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String content_id = rs.getString(1);
                String first_image = rs.getString(2);
                String title = rs.getString(3);
                String content_type_id = rs.getString(4);
                String sido_code = rs.getString(5);
                String gugun_code = rs.getString(6);
                String addr1 = rs.getString(7);
                String second_image = rs.getString(8);

                AttractionInfo info = new AttractionInfo(content_id, content_type_id, title, addr1, null, null, null, first_image, second_image, null, sido_code, gugun_code, null, null, null);
                infoList.add(info);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return infoList;
    }

    @Override
    public AttractionInfo selectOne(String contentId) {
        AttractionInfo info = null;
        try {
            Connection con = util.getConnection();
            String q = "select content_id, content_type_id, first_image2, title, addr1 from attraction_info where content_id = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, contentId);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String content_id = rs.getString(1);
                String content_type_id = rs.getString(2);
                String second_image = rs.getString(3);
                String title = rs.getString(4);
                String addr1 = rs.getString(5);

                info = new AttractionInfo(content_id, content_type_id, title, addr1, null, null, null, null, second_image, null, null, null, null, null, null);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return info;
    }

    @Override
    public ContentDescription selectDescription(String contentId) {
        ContentDescription des = null;
        try {
            Connection con = util.getConnection();
            String q = "select content_id, overview from attraction_description where content_id = ?";
            PreparedStatement stat = con.prepareStatement(q);
            stat.setString(1, contentId);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String content_id = rs.getString(1);
                String overview = rs.getString(2);

                des = new ContentDescription(contentId, overview);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return des;
    }

    @Override
    public int getTotalArticleCount(Map<String, Object> param) {
        int cnt = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String q = "select count(content_id) from attraction_info where content_type_id = ?";
        try {
            conn = util.getConnection();

            String word = (String) param.get("word");
            String content_type_id = (String) param.get("content_type_id");
            if (!word.isEmpty()) {
                q += " and title like concat('%', ?, '%')";
                pstmt = conn.prepareStatement(q);
                pstmt.setString(1, content_type_id);
                pstmt.setString(2, word);
            }
            else {
                pstmt = conn.prepareStatement(q);
                pstmt.setString(1, content_type_id);
            }
            rs = pstmt.executeQuery();

            if (rs.next()) {
                cnt = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pstmt, conn);
        }
        return cnt;
    }
}
