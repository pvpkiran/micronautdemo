package in.phani.micronaut;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class CompileTimeClientTest {

    @Inject
    BookDepotClient client;

    @Test
    public void testHelloWorldResponse(){
        assertEquals("welcome", client.hello().blockingGet());
    }
}