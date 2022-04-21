package org.zerock.guestbook.svc.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestBookDTO;
import org.zerock.guestbook.entity.GuestBook;
import org.zerock.guestbook.repository.GuestbookRepository;
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
@RequiredArgsConstructor
public class GuestBookServiceImpl implements GuestBookService {

    private final GuestbookRepository guestbookRepository;

    @Override
    public Long registGuestbook(GuestBookDTO guestBookDTO) {

        log.info("DTO --------------------------------");
        log.info(guestBookDTO);

        GuestBook gbEntity = dtoToEntity(guestBookDTO);
        log.info(gbEntity);

        guestbookRepository.save(gbEntity);

        return gbEntity.getGno();
    }
}
