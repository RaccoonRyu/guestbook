package org.zerock.guestbook.svc.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestBookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.GuestBook;
import org.zerock.guestbook.repository.GuestbookRepository;
import org.zerock.guestbook.svc.GuestBookService;

import java.util.function.Function;

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

    @Override
    public PageResultDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO pageRequestDTO) {

        Pageable page = pageRequestDTO.getPageable(Sort.by("gno").descending());

        Page<GuestBook> guestBookPage = guestbookRepository.findAll(page);

        Function<GuestBook, GuestBookDTO> fn = (entity -> entityTodto(entity));

        return new PageResultDTO<>(guestBookPage, fn);
    }
}
