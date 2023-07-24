package org.zerock.b01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.QBoard;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        // QBoard는 Board 클래스에 대응하는 Querydsl Query 타입입니다.
        // board 변수를 통해 Querydsl로 Board 테이블에 대한 쿼리를 작성할 수 있습니다.
        QBoard board = QBoard.board;

        // from 메서드를 사용해서 쿼리의 시작점을 설정하고, JPQLQuery 객체를 생성합니다.
        // 이 쿼리는 Board 테이블에 대한 쿼리를 나타냅니다.
        JPQLQuery<Board> query = from(board); // select * from board

        // where 메서드를 사용해서 쿼리의 조건을 설정합니다.
        // 이 경우, board 테이블의 title 칼럼이 "1"을 포함하는 모든 레코드를 찾습니다.
        query.where(board.title.contains("1"));

        // applyPagination 메서드를 통해, 페이징을 적용합니다.
        // pageable 객체는 페이징을 위한 정보를 담고 있습니다. (페이지 번호, 페이지 사이즈 등)
        this.getQuerydsl().applyPagination(pageable,query);

        // fetch 메서드를 호출해서 쿼리를 실행하고, 결과를 List 형태로 가져옵니다.
        List<Board> list = query.fetch();

        // fetchCount 메서드를 호출해서 쿼리에 해당하는 전체 레코드 수를 카운트합니다.
        long count = query.fetchCount();

        // 현재 null을 반환하고 있지만, 일반적으로는 Page 형태로 결과를 반환합니다.
        // Page는 Spring Data JPA에서 제공하는 인터페이스로, 페이징된 데이터를 표현하기 위해 사용됩니다.
        return null;
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;

        JPQLQuery<Board> query= from(board);

        if((types != null && types.length > 0 ) && keyword != null){


            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type: types){
                switch (type){

                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }//end if


        query.where(board.bno.gt(0L));

        this.getQuerydsl().applyPagination(pageable,query);

        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list,pageable,count);
    }
}
