package service;

import dao.AttractionInfoDAO;
import dao.AttractionInfoDAOImpl;
import vo.AttractionInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttractionInfoServiceImpl implements AttractionInfoService {
    AttractionInfoDAO dao;
    public AttractionInfoServiceImpl() {
        dao = new AttractionInfoDAOImpl();
    }

    @Override
    public ArrayList<AttractionInfo> selectAll() {
        return null;
    }

    @Override
    public ArrayList<String> selectSido() throws SQLException {
        return dao.selectSido();
    }

    @Override
    public ArrayList<String> selectGugun(String sidoName) throws SQLException {
        return dao.selectGugun(sidoName);
    }

    @Override
    public ArrayList<AttractionInfo> search(String sidoName, String gugunName, String keyword) throws SQLException {
        return dao.search(sidoName, gugunName, keyword);
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
