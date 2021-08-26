package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParmaV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username = {}, age = {}", memberName, memberAge);
        return "v2 ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username = {}, age = {}", username, age);
        return "v3 ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {

        log.info("username = {}, age = {}", username, age);
        return "v4 ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, // 주의 - parameter 이름만 있고 값이 없으면 빈문자로 통과된다.
            @RequestParam(required = false) Integer age) {

        log.info("username = {}, age = {}", username, age);
        return "required ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, // 주의 - defaultValue를 설정하면 빈문자를 넘겨도 defaultValue로 값이 할당된다.
            @RequestParam(required = false, defaultValue = "-1") int age) {

        log.info("username = {}, age = {}", username, age);
        return "default ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap) {

        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "map ok";
    }
}
