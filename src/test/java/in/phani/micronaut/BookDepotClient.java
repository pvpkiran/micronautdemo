package in.phani.micronaut;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("/bookdepot")
public interface BookDepotClient {

    @Get
    Single<String> hello();
}