package site.mindol.book.springboot.config.auth.dto;

import lombok.Getter;
import site.mindol.book.springboot.domain.user.User;

import javax.mail.Session;
import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

/**
 * 직렬화 기능을 가진 세션 Dto
 * SessionUser 에는 인증된 사용자 정보만 필요함
 * 그 외에 필요한 정보들은 없으니 name, email, picture 만 필드로 선언한다.
 */