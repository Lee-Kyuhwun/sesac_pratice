package kr.or.connect.reservation.controller;


import io.swagger.annotations.ApiOperation;
import kr.or.connect.reservation.Mapper.CategoryMapper;
import kr.or.connect.reservation.dto.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
//@RequestMapping("/api/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryMapper categoryMapper;


    @ApiOperation(value = "카테고리 반환", notes = "카테고리들을 반환하고 연관 display_info의 갯수를 보여준다. ")
    @GetMapping("/category")
    public ResponseEntity<Map<String, Object>> findCategoryAll(){
        List<Category> categories = categoryMapper.getCategoriesWithDisplayCount();
       Map<String, Object> response = new HashMap<>();
       response.put("size", categories.size());
        response.put("items", categories);

        return ResponseEntity.ok(response);
    }

}
