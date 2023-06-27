package kr.or.connect.reservation.controller;

import io.swagger.annotations.ApiOperation;
import kr.or.connect.reservation.Mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
*
*
*  localhost:8080/category -> ??? 어떻게 나온거지?
* 컨트롤러 -0
* */

@RestController
//@RequestMapping("/api/")
@RequiredArgsConstructor
public class CategoryController {



    private final CategoryMapper categoryMapper;


// final -> 무조건 초기화 시켜줘야해요.

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