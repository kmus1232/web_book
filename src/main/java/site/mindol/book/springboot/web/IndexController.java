package site.mindol.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import site.mindol.book.springboot.config.auth.LoginUser;
import site.mindol.book.springboot.config.auth.dto.SessionUser;
import site.mindol.book.springboot.service.posts.PostsService;
import site.mindol.book.springboot.web.dto.PostsResponseDto;

import javax.servlet.http.HttpSession;

/**
 * 웹 페이지에 관련된 컨트롤러는 모두 IndexController를 사용한다
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
