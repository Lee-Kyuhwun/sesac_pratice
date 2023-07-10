package org.zeorck.jdbcex.domain;


import lombok.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {

    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;



}
/*
*  TODoVO는 데이터베이스 내에 생성한 tbl_todo 테이블의 칼럼들을 기준으로 작성한다.
*  주로 읽기 전용으로 사용하는 경우가 많아서 getter만 추가
* 빌더 패턴 이용하기 위해 builder 추가
*
* */