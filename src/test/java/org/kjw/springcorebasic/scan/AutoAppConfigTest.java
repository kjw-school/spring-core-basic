package org.kjw.springcorebasic.scan;

import org.junit.jupiter.api.Test;
import org.kjw.springcorebasic.AutoAppConfig;
import org.kjw.springcorebasic.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }

}
