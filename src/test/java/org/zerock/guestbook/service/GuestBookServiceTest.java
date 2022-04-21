package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestBookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.GuestBook;
import org.zerock.guestbook.svc.GuestBookService;

/**
 * GuestBookServiceTest
 * - 방명록 서비스 테스트용 모듈
 *
 * @author 류지헌
 * @created 2022-04-21
 */
@SpringBootTest
public class GuestBookServiceTest {

    @Autowired
    private GuestBookService guestBookService;

    @Test
    public void testRegister() { // DTO를 Entity로 변환(DB반영은 X) 확인

        GuestBookDTO guestBookDTO = GuestBookDTO.builder()
                .title("Sample Title")
                .content("Sample Content")
                .writer("Sample User")
                .build();

        System.out.println(guestBookService.registGuestbook(guestBookDTO));
    }

    @Test
    public void testList() { // Entity가 DTO로 변환되었는지 확인
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        PageResultDTO<GuestBookDTO, GuestBook> gbResultDTO = guestBookService.getList(pageRequestDTO);

        for(GuestBookDTO guestbookDTO : gbResultDTO.getDtoList()) {
            System.out.println(guestbookDTO);
        }
    }
}
