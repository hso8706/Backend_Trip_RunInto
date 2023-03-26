package service;

import vo.AttractionInfo;

import java.util.ArrayList;

public interface CategoryService {
    ArrayList<AttractionInfo> selectCategory(String categoryNum);
}
