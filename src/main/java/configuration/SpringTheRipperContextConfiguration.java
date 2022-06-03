package configuration;

import org.springframework.context.annotation.*;
import quoters.InjectRandomIntAnnotationBeanPostProcessor;
import quoters.PostProxyInvokerContextListener;
import quoters.ProfilingHandlerBeanPostProcessor;
import quoters.TerminatorQuoter;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

@Configuration
@ComponentScan(basePackages = "quoters")
public class SpringTheRipperContextConfiguration {

    @Bean
    public TerminatorQuoter terminatorQuoter() {
        TerminatorQuoter terminatorQuoter = new TerminatorQuoter();
        terminatorQuoter.setMessage("I'll be back");
        return terminatorQuoter;
    }
}
