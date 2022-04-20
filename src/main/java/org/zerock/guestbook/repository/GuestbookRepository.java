package org.zerock.guestbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.dto.GuestBookDTO;

/**
 * GuestbookRepository
 * - 방명록 엔티티 객체를 처리할 리포지토리
 *
 * @author 류지헌
 * @created 2022-04-20
 */
public interface GuestbookRepository extends JpaRepository<GuestBookDTO, Long>,
        QuerydslPredicateExecutor<GuestBookDTO> {
}
