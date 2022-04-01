package spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Spring01Application {

    @PostConstruct
    public void init() {
        // 解决netty启动冲突 -> elasticsearch与redis冲突
        // Netty4Utils.setAvailableProcessors()
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    public static void main(String[] args) {

        SpringApplication.run(Spring01Application.class, args);
    }

}
