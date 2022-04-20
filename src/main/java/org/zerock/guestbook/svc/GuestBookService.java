package org.zerock.guestbook.svc;

import org.zerock.guestbook.dto.GuestBookDTO;

/**
 * GuestBookService
 * - 방명록 서비스 인터페이스
 *
 * @author 류지헌
 * @created 2022-04-20
 */
public interface GuestBookService {
    Long registGuestbook(GuestBookDTO guestBookDTO);
}
