package kr.or.connect.reservation.service;


import kr.or.connect.reservation.Mapper.DisplayInfoMapper;
import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.ProductDisplayInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisplayInfoService {

    private final DisplayInfoMapper displayInfoMapper;

    public ProductDisplayInfo getDisplayInfo(@PathVariable  int id){
        return displayInfoMapper.getDisplayInfo(id);
    }
    // 새로운 메소드 추가
    public ProductDisplayInfoResponse getDisplayInfoResponse(){
        ProductDisplayInfoResponse response = new ProductDisplayInfoResponse();
        List<ProductDisplayInfo> allDisplayInfo = (List<ProductDisplayInfo>) displayInfoMapper.getAllDisplayInfo();

        response.setTotalCount(allDisplayInfo.size());  // 전체 상품 수
        response.setProductCount(allDisplayInfo.size());  // 반환된 상품 리스트의 길이
        response.setProducts(allDisplayInfo);  // ProductDisplayInfo 리스트

        return response;
    }
}
/*
*
*
*
* */