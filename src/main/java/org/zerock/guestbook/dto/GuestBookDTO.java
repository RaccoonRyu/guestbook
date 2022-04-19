package org.zerock.guestbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * GuestBookDTO
 * - 방명록 CRUD에 사용될 엔티티 객체
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuestBookDTO extends BaseDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno; // 방명록 번호
    
    @Column(length = 100, nullable = false)
    private String title; // 방명록 제목

    @Column(length = 1500, nullable = false)
    private String content; // 방명록 글 내용

    @Column(length = 50, nullable = false)
    private String writer; // 방명록 작성자
}
