package com.reactiveprogramming.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {


    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("Webflux")
                .then(Mono.error(new RuntimeException("Exception occured")))
                .log();
        monoString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
    }
}
