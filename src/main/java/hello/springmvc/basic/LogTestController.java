package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller는 메소드의 반환값이 String이면 뷰이름으로 인식한다.
//허나 @RestController는 메소드의 반환 값을 바로 Http 메시지 바디에 입력한다.
//@Slf4j = private final Logger log = LoggerFactory.getLogger(getClass());
@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        //만약에 level이 trace상위 단으로 설정되어있으면,
        // string을 더하기 때문에 쓸때없는 연산이 발생함
        log.trace(" trace my log=" + name);

        //log level 순으로 출력 tarce -> error로 갈수록 상위
        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name);
        log.info("info log = {}", name);
        log.warn("warn log = {}", name);
        log.error("error log = {}", name);

        return "ok";
    }
}
