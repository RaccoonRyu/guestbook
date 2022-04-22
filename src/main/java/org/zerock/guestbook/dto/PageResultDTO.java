package org.zerock.guestbook.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * PageResultDTO
 * - 화면에 출력할 페이지 결과를 처리하는 DTO
 *
 * @author 류지헌
 * @created 2022-04-21
 */
@Data
public class PageResultDTO<DTO, EN> {

    private List<DTO> dtoList; // GuestBookDTO 리스트

    private int totalPage; // 총 페이지 번호

    private int page; // 현재 페이지 번호

    private int size; // 페이지 목록의 크기

    private int start; // 시작 페이지 번호

    private int end; // 끝 페이지 번호

    private boolean prev; // 이전 페이지 버튼

    private boolean next; // 다음 페이지 버튼

    private List<Integer> pageList; // 페이지 번호 목록

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());

        totalPage = result.getTotalPages(); // 총 페이지 번호

        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable) {

        this.page = pageable.getPageNumber()+1; // page는 0부터 시작하므로 화면출력을 위해 1 추가
        this.size = pageable.getPageSize();

        // 임시 페이지 설정들
        int tempEnd = (int)(Math.ceil(page/10.0)) * 10; // 끝 페이지. 소수점을 올림처리하는 Math.ceil()

        start = tempEnd - 9; // 시작 페이지

        prev = start > 1; // 이전 페이지

        next = totalPage > tempEnd; // 다음 페이지

        end = totalPage > tempEnd ? tempEnd : totalPage; // 끝 페이지 번호

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
