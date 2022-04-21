package org.zerock.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * PageRequestDTO
 * - 화면의 페이지 목록 처리를 위한 DTO
 *
 * @author 류지헌
 * @created 2022-04-21
 */
@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    
    private int page; // 페이지 번호
    private int size; // 페이지 크기
    
    public PageRequestDTO() { // 생성시 페이지 내 값들의 기본값 설정
        this.page = 1; // 페이지 번호의 기본값
        this.size = 10; // 페이지 크기의 기본값
    }

    public Pageable getPageable(Sort sort) { // JPA 이용시 페이징을 위한 함수
        return PageRequest.of(page-1, size, sort); // JPA 이용시 페이지번호가 0부터 시작하기 때문에 1을 빼준다.
        // 정렬조건은 나중에 다양한 조건을 사용하기 위해 별도의 파라미터로 받도록 작성한다.
    }
}
