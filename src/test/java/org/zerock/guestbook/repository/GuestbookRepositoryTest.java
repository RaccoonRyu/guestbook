package org.zerock.guestbook.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.zerock.guestbook.dto.GuestBook;

import org.springframework.data.domain.*;
import org.zerock.guestbook.dto.QGuestBook;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * GuestbookRepositoryTest
 * - Querydsl로 엔티티를 테스트하는 클래스
 * 
 * @author 류지헌
 * @created 2022-04-19
 */
@SpringBootTest
public class GuestbookRepositoryTest {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    public void insertDummies() { // 300개의 테스트 데이터 삽입
        IntStream.rangeClosed(1,300).forEach(i ->{

            GuestBook guestBook = GuestBook.builder()
                    .title("Title : "+i)
                    .content("Content : "+i)
                    .writer("User : "+i)
                    .build();
            System.out.println(guestbookRepository.save(guestBook));
        });
    }

    @Test
    public void updateTest() { // 최종 수정시간 반영 테스트
        Optional<GuestBook> result = guestbookRepository.findById(300L);

        if(result.isPresent()){
            GuestBook guestBook = result.get();

            guestBook.setTitle("Change Title");
            guestBook.setContent("Change Content");

            guestbookRepository.save(guestBook);
        }
    }

    @Test
    public void testQuery1() { // Querydsl 사용하여 단일항목 검색+페이지 처리 테스트
        // 제목에 1이라는 글자가 있는 엔티티들을 검색하는 테스트
        Pageable page = PageRequest.of(0, 10, Sort.by("gno").descending());

        QGuestBook qGuestBook = QGuestBook.guestBook;

        String keyword = "1";
        
        // 엔티티 검색 조건(where문)을 담을 컨테이너(BooleanBuilder) 작성
        BooleanBuilder builder = new BooleanBuilder();

        // 엔티티 검색 조건을 작성
        BooleanExpression expression = qGuestBook.title.contains(keyword);
        
        // 엔티티 검색 조건을 and나 or 키워드와 결합 후 BooleanBuilder에 추가
        builder.and(expression);
        
        // BooleanBuilder 실행
        Page<GuestBook> result = guestbookRepository.findAll(builder, page);

        result.stream().forEach(guestBook -> {
            System.out.println(guestBook);
        });
    }

    @Test
    public void testQuery2() { // Querydsl 사용하여 다중항목 검색(제목/내용에 특정키워드+방명록번호)
        // 제목혹은 내용에 특정 키워드가 있고 gno가 0보다 큰 엔티티들을 검색하는 테스트
        Pageable page = PageRequest.of(0, 10, Sort.by("gno").descending());

        QGuestBook qGuestBook = QGuestBook.guestBook;

        String keyword = "1";

        // 엔티티 검색 조건(where문)을 담을 컨테이너(BooleanBuilder) 작성
        BooleanBuilder builder = new BooleanBuilder();

        // 엔티티 검색 조건을 작성
        BooleanExpression exTitle = qGuestBook.title.contains(keyword);

        BooleanExpression exContent = qGuestBook.content.contains(keyword);

        // 엔티티 검색 조건을 and나 or 키워드에 결합
        BooleanExpression exAll = exTitle.or(exContent);

        // 결합한 엔티티 검색 조건을 BooleanBuilder에 추가
        builder.and(exAll);

        // 검색 조건을 특정 변수에 할당하지 않고 바로 결합할 수 있다.
        builder.and(qGuestBook.gno.gt(0L)); // gno가 0보다 큰 조건

        // BooleanBuilder 실행
        Page<GuestBook> result = guestbookRepository.findAll(builder, page);

        result.stream().forEach(guestBook -> {
            System.out.println(guestBook);
        });
    }
}
