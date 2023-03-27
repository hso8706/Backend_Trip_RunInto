package dao;

import vo.AttractionInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttractionInfoDAO {
    ArrayList<AttractionInfo> selectAll();
    AttractionInfo selectOne(String contentId);
    ArrayList<String> selectSido() throws SQLException;

    ArrayList<String> selectGugun(String sidoName) throws SQLException;
    ArrayList<AttractionInfo> search(String sidoCode, String gugunCode, String keyword) throws SQLException;

    int insert(AttractionInfo attractionInfo);
    String getSidoCode(String sidoName);

    String getGugunCode(String sidoCode, String gugunName);

    int delete(String contentId);
}
