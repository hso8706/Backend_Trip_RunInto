package dao;

import vo.AttractionInfo;

import java.util.ArrayList;

public interface CategoryDAO {
    ArrayList<AttractionInfo> selectCategory(String categoryNum);
}
