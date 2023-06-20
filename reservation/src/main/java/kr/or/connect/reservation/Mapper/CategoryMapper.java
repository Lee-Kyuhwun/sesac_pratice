package kr.or.connect.reservation.Mapper;


import kr.or.connect.reservation.dto.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> getCategoriesWithDisplayCount();
}
