package service;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import vo.AttractionInfo;

import java.util.ArrayList;

public class CategoryServiceImpl implements CategoryService{
    CategoryDAO cdao;

    public CategoryServiceImpl() {
        cdao = new CategoryDAOImpl();
    }

    @Override
    public ArrayList<AttractionInfo> selectCategory(String categoryNum) {
        return cdao.selectCategory(categoryNum);
    }
}
