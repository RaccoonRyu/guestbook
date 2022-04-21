package org.zerock.guestbook.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * PageResultDTO
 * - 화면에 출력할 페이지 결과를 처리하는 DTO
 *
 * @author 류지헌
 * @created 2022-04-21
 */
@Data
public class PageResultDTO<DTO, EN> {

    private List<DTO> dtoList;

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());
    }
}
