package org.zerock.w2.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // @Data는 Lombok 어노테이션으로, getter, setter, equals, hashCode, toString 메서드를 자동으로 생성해줍니다.
@Builder  // @Builder는 Lombok 어노테이션으로, 이 클래스에 대한 빌더 패턴 클래스를 생성합니다. 빌더 패턴을 사용하면 객체 생성 과정과 표현 방법을 분리하여 코드의 가독성을 높여줍니다.
@AllArgsConstructor  // @AllArgsConstructor는 Lombok 어노테이션으로, 모든 필드 값을 파라미터로 받는 생성자를 만들어줍니다.
@NoArgsConstructor  // @NoArgsConstructor는 Lombok 어노테이션으로, 파라미터가 없는 기본 생성자를 생성해줍니다.
public class MemberDTO {
    private String mid;  // 회원의 ID를 저장하는 인스턴스 변수입니다.
    private String mpw;  // 회원의 비밀번호를 저장하는 인스턴스 변수입니다.
    private String mname;  // 회원의 이름을 저장하는 인스턴스 변수입니다.
}
