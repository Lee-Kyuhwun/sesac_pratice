package org.zerock.w2.service;


import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.MemberDAO;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.util.MapperUtil;

@Log4j2  // @Log4j2는 Lombok의 로깅(Logging) 어노테이션입니다. 이 어노테이션을 통해 로깅을 위한 log 객체가 자동으로 생성되며, 이를 통해 로깅 메시지를 출력할 수 있습니다.
public enum MemberService {  // enum 키워드로 싱글톤 패턴을 구현한 서비스 클래스를 정의합니다.

    INSTANCE;  // enum의 인스턴스가 하나만 존재하므로, 이 인스턴스를 통해 싱글톤을 구현합니다.

    private MemberDAO dao;  // MemberDAO 객체를 private 필드로 선언합니다. 이를 통해 데이터베이스와의 연동을 관리합니다.
    private ModelMapper modelMapper;  // ModelMapper 객체를 private 필드로 선언합니다. 이를 통해 데이터 객체와 DTO 간의 변환을 관리합니다.

    MemberService(){  // 생성자를 private으로 선언하여 외부에서의 인스턴스 생성을 제한합니다.

        dao = new MemberDAO();  // MemberDAO 객체를 생성하여 초기화합니다.
        modelMapper = MapperUtil.INSTANCE.get();  // MapperUtil을 통해 ModelMapper 객체를 가져와 초기화합니다.

    }

    public MemberDTO login(String mid, String mpw) throws Exception{  // login 메서드를 선언합니다. 파라미터로는 mid와 mpw를 받습니다.
        MemberVO vo = dao.getWithPassword(mid, mpw);  // DAO를 사용해 mid와 mpw에 해당하는 사용자 정보를 데이터베이스에서 가져옵니다. 그 결과를 MemberVO 객체로 저장합니다.

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);  // ModelMapper를 이용해 MemberVO 객체를 MemberDTO 객체로 변환합니다. 이 과정을 통해 비즈니스 로직과 표현 로직을 분리할 수 있습니다.

        return memberDTO;  // 변환된 MemberDTO 객체를 반환합니다. 이 객체는 표현 계층에서 사용자 정보를 처리하는 데 사용됩니다.

    }


}

