package org.zerock.guestbook.dto;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * BaseDTO
 * - 엔티티 객체의 등록/최종 수정시간을 담당할 추상클래스
 *
 * @author 류지헌
 * @created 2022-04-19
 */
@MappedSuperclass // 해당 어노테이션이 적용된 클래스는 테이블로 생성되지 않음
@EntityListeners(value = {AuditingEntityListener.class}) // JPA 내부에서 엔티티 객체가 생성/변경됨을 감지하는 어노테이션
@Getter
abstract class BaseDTO {
    
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate; // 등록 시간
    
    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate; // 최종 수정 시간
    
}
