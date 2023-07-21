package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    // 회원 정보를 가져오는 메소드. mid와 mpw가 일치하는 회원의 정보를 반환한다.
    public MemberVO getWithPassword(String mid, String mpw) throws Exception {

        // mid와 mpw가 일치하는 회원의 정보를 조회하는 SQL 문장
        String query = "select mid, mpw, mname from tbl_member where mid = ? and mpw = ?";

        // 반환할 MemberVO 객체. 아직 초기화되지 않았다.
        MemberVO memberVO = null;

        // Cleanup 어노테이션을 사용해 자동으로 종료되도록 함. 데이터베이스 연결을 가져온다.
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        // Cleanup 어노테이션을 사용해 자동으로 종료되도록 함. PreparedStatement를 생성하고 SQL 문장을 준비한다.
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);
        // 첫 번째 물음표에 mid 값을 설정한다.
        preparedStatement.setString(1, mid);
        // 두 번째 물음표에 mpw 값을 설정한다.
        preparedStatement.setString(2, mpw);
        // Cleanup 어노테이션을 사용해 자동으로 종료되도록 함. SQL 문장을 실행하고 결과를 가져온다.
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        // 결과 셋의 첫 번째 행으로 이동한다. (일반적으로 select 쿼리의 결과로 하나의 행만 반환되어야 함)
        resultSet.next();

        // 결과 셋에서 회원 정보를 가져와 MemberVO 객체를 생성하고 초기화한다.
        memberVO = MemberVO.builder()
                .mid(resultSet.getString(1))    // 첫 번째 컬럼(=mid)의 값을 가져온다.
                .mpw(resultSet.getString(2))    // 두 번째 컬럼(=mpw)의 값을 가져온다.
                .mname(resultSet.getString(3))  // 세 번째 컬럼(=mname)의 값을 가져온다.
                .build();

        // 초기화된 MemberVO 객체를 반환한다.
        return memberVO;
    }
}
