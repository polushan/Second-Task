package controllers;

import dao.RequestDao;
import model.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(@RequestParam Map<String, String> params, HttpServletRequest req) {
        String dspId = params.get("dspId");
        String userId = getUserId(req);
        String externalUserId = params.get("externalUserId");
        if (dspId != null && externalUserId != null) {
            save(dspId, userId, externalUserId);
        }
        return "index";
    }

    private void save(String dspId, String userId, String externalUserId) {
        try {
            new RequestDao().saveRequest(new Request(dspId, userId, externalUserId));
        } catch (SQLException e) {
            System.out.println("Can't save request. Maybe not unique value userId-externalUserId");
        }

    }


    private String getUserId(HttpServletRequest req) {
        return Arrays.stream(req.getCookies())
                .filter(c -> "userId".equals(c.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse("testId");
    }
}
