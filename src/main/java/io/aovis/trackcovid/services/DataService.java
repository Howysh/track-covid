package io.aovis.trackcovid.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//This makes this class as a spring
@Service
public class DataService {

    //this makes an http call to the following url
    private static String VIRUS_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_US.csv";

    //Tells spring to execute once it's done constructing
    @PostConstruct
    //method creation
    public void fetchCovidData() throws IOException, InterruptedException {
        //Creates a new request
        HttpClient client = HttpClient.newHttpClient();
        //Class request that uses the build addon
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        //prints out the response
        System.out.println(httpResponse.body());

        
    }
}
