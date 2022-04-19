package org.zerock.guestbook.ctrl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class GuestbookController {

    @GetMapping({"/", "/list"})
    public String list(){
        log.info("list..................");

        return "/guestbook/list";
    }
}
