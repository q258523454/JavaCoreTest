package javacore.jdk18.optional;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
public class Optional_OrElse {
    public static void main(String[] args) {

        String nowDate = LocalDate.now().toString();
        System.out.println(nowDate);
    }
}
