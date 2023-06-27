package kr.or.connect.reservation.dto;


import lombok.Getter;
import lombok.Setter;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Getter
@Setter
public class ProductDisplayInfoResponse {
    private int totalCount;
    private int productCount;
    private List<ProductDisplayInfo> products;
}
