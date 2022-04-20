package org.zerock.guestbook.svc.Impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestBookDTO;
import org.zerock.guestbook.svc.GuestBookService;

/**
 * GuestBookServiceImpl
 * - 방명록 서비스 Impl
 *
 * @author 류지헌
 * @created 2022-04-20
 */
@Service
@Log4j2
public class GuestBookServiceImpl implements GuestBookService {

    @Override
    public Long registGuestbook(GuestBookDTO guestBookDTO) {
        return null;
    }
}
