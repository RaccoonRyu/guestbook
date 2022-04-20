package org.zerock.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * GuestBookDTO
 * - 방명록 게시글을 처리할 모델 클래스
 *
 * @author 류지헌
 * @created 2022-04-20
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestBookDTO {
    
    private Long gno; // 방명록 번호
    private String title; // 방명록 제목
    private String content; // 방명록 내용
    private String writer; // 방명록 작성자
    private LocalDateTime regDate; // 방명록 등록일시
    private LocalDateTime modDate; // 방명록 수정일시
    
}
