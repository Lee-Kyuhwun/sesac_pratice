package kr.or.connect.reservation.Mapper;

import kr.or.connect.reservation.dto.ProductDisplayInfo;
import kr.or.connect.reservation.dto.ProductDisplayInfoResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DisplayInfoMapper {


    ProductDisplayInfo getDisplayInfo(int id);
    // 새로운 메소드 추가
    ProductDisplayInfoResponse getAllDisplayInfo();
}
