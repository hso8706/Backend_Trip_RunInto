package service;

import vo.AttractionInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttractionInfoService {
    ArrayList<AttractionInfo> selectAll();

    ArrayList<String> selectSido() throws SQLException;
    ArrayList<String> selectGugun(String sidoName) throws SQLException;

    ArrayList<AttractionInfo> search(String sidoName, String gugunName, String keyword) throws SQLException;

    int insert(AttractionInfo attractionInfo);

    int delete(String contentId);
}
