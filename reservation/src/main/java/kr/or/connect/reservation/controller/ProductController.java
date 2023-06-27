package kr.or.connect.reservation.controller;


import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.ProductDisplayInfoResponse;
import kr.or.connect.reservation.service.DisplayInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final DisplayInfoService displayInfoService;





    @GetMapping("/displayInfo/{id}")
    public ProductDisplayInfo getDisplayInfo(@PathVariable int id) {
        return displayInfoService.getDisplayInfo(id);
    }
    // 새로운 메소드 추가
    @GetMapping("/displayInfoResponse")
    public ProductDisplayInfoResponse getDisplayInfoResponse() {
        return displayInfoService.getDisplayInfoResponse();
    }
}
