package org.zerock.guestbook.svc;

import org.zerock.guestbook.dto.GuestBookDTO;
import org.zerock.guestbook.entity.GuestBook;

/**
 * GuestBookService
 * - 방명록 서비스 인터페이스
 *
 * @author 류지헌
 * @created 2022-04-20
 */
public interface GuestBookService {
    Long registGuestbook(GuestBookDTO guestBookDTO);

    default GuestBook dtoToEntity(GuestBookDTO guestBookDTO) {
        GuestBook gbEntity = GuestBook.builder()
                .gno(guestBookDTO.getGno())
                .title(guestBookDTO.getTitle())
                .content(guestBookDTO.getContent())
                .writer(guestBookDTO.getWriter())
                .build();

        return gbEntity;
    }
}
