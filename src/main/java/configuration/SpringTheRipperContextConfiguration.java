package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quoters.TerminatorQuoter;

@Configuration
public class SpringTheRipperContextConfiguration {

//    @Bean
//    public String terminatorQuote() {
//        return "I'll be back";
//    }

    @Bean
    public TerminatorQuoter terminatorQuoter() {
        TerminatorQuoter terminatorQuoter = new TerminatorQuoter();
        terminatorQuoter.setMessage("I'll be back");
        return terminatorQuoter;
    }
}
