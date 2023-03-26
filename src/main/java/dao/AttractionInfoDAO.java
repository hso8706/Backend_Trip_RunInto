package dao;

import vo.AttractionInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttractionInfoDAO {
    ArrayList<AttractionInfo> selectAll();
    AttractionInfo selectOne(String contentId);
    ArrayList<String> selectSido() throws SQLException;

    ArrayList<String> selectGugun(String sidoCode) throws SQLException;

    int insert(AttractionInfo attractionInfo);

    int delete(String contentId);
}
