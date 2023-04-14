package com.example.speedtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class SpeedtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeedtestApplication.class, args);
    }


    @RestController
    public static class SpeedTestController {
        @GetMapping("/speed")
        public void speedTest(@RequestParam Integer fileSize,
                              HttpServletResponse response) throws IOException {
            System.gc();
            if (null == fileSize) {
                fileSize = 1024;
            }
            response.setHeader("content-disposition", "attachment;filename=speedTest");
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[fileSize * 1024 * 1024];
            outputStream.write(bytes);
            outputStream.flush();
        }
    }

}
