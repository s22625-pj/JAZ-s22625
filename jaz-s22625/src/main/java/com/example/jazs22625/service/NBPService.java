package com.example.jazs22625.service;

import com.example.jazs22625.model.Database;
import com.example.jazs22625.model.Rate;
import com.example.jazs22625.model.Rates;
import com.example.jazs22625.repository.NBPRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NBPService {
    private final RestTemplate restTemplate;
    private final NBPRepo nbpRepo;
    private final String url = "http://api.nbp.pl/api/exchangerates/tables/a/";

    public NBPService(RestTemplate restTemplate, NBPRepo nbpRepo) {
        this.restTemplate = restTemplate;
        this.nbpRepo = nbpRepo;
    }

    public Database currencyCount(String from, String to, Long currencies){
        Rates response = restTemplate.getForObject(url + "{avg}/{from}/{to}?format=json", Rates.class, from, to, currencies);

        Long ccount = response.getRates().stream()
                .map(Rate::getCode)
                .mapToDouble(s -> s)
                .average()
                .count()
                .orElseThrow();

        Database dbResponse = new Database(from,to,ccount);

        return nbpRepo.save(dbResponse); // zapisanie danych do bazy

    }
}
