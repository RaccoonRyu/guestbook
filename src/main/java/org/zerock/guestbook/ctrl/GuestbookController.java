package org.zerock.guestbook.ctrl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.svc.GuestBookService;

/**
 * GuestbookController
 * - 방명록 컨트롤러
 *
 * @author 류지헌
 * @created 2022-04-19
 */
@Controller
@RequestMapping("/guestbook")
@Log4j2
@RequiredArgsConstructor // 클래스 선언시 서비스 자동 주입
public class GuestbookController {

    private final GuestBookService guestBookService;

    /**
     * getIndex
     * - 시작주소 (/) 입력시 방명록 목록 조회
     *
     * @author 류지헌
     * @created 2022-04-22
     */
    @GetMapping("/")
    public String getIndex() {
        return "redirect:/guestbook/list";
    }

    /**
     * getList
     * - 방명록 목록 조회
     *
     * @author 류지헌
     * @created 2022-04-22
     * @param pageRequestDTO
     * @param model
     */
    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        log.info("list..................");

        model.addAttribute("result", guestBookService.getList(pageRequestDTO));
    }
}
