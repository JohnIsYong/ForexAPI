package com.dev.forex;


import com.dev.forex.service.ForexQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class ForexRestController {

    private ForexQueryService forexQueryService;

    @Autowired
    public ForexRestController(ForexQueryService forexQueryService){
        this.forexQueryService = forexQueryService;
    }

    @GetMapping("/forexqueries")
    public List<ForexQuery> history(){
        return forexQueryService.listAll();
    }

    @GetMapping("/forexqueries/{queryGuide}")
    public List<ForexQuery> findByInputCurrency(@PathVariable String queryGuide) {
        String currencyRegex = "[a-zA-Z]{3}";
        String numberRegex = "[0-9]+";
//        if (queryGuide.matches(currencyRegex)) {

//        }
        return forexQueryService.findByInputCurrency(queryGuide);

    }

    @GetMapping("/forexqueries/int/{queryNumber}")
    public ForexQuery findByQueryNumber(@PathVariable int queryNumber){
        return forexQueryService.findByQueryNumber(queryNumber);
    }

    @PostMapping("/forexqueries/{apiKey}")
    public ForexQuery addQuery(@PathVariable String apiKey, @RequestBody Map<String, String> partialQuery){
        String uri = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + partialQuery.get("inputCurrency");

        System.out.println(uri);


        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> result = restTemplate.getForObject(uri, Map.class);
        Map<String, Double> conversionRates = (Map<String, Double>) result.get("conversion_rates");
        Double exchangeRate = (Double) conversionRates.get(partialQuery.get("outputCurrency").toUpperCase());
        if(exchangeRate == null){
            return null;
        }
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String patternDate = "dd-MM-yyyy";
        String patternTime = "HH:mm:ss";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(patternDate);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(patternTime);
        String formattedDate = date.format(dateFormatter);
        String formattedTime = time.format(timeFormatter);

        ForexQuery newQuery = new ForexQuery(
                partialQuery.get("inputCurrency").toUpperCase(),
                partialQuery.get("outputCurrency").toUpperCase(),
                exchangeRate,
                formattedDate,
                formattedTime);

        return forexQueryService.addQuery(newQuery);
    }

    @DeleteMapping("/forexqueries/int/{queryNumber}")
    public ForexQuery deleteByQueryNumber(@PathVariable int queryNumber){
        return forexQueryService.deleteByQueryNumber(queryNumber);
    }

    @DeleteMapping("/forexqueries/{currency}")
    public Integer deleteByInputCurrency(@PathVariable String currency){
        return forexQueryService.deleteByInputCurrency(currency);
    }


}


























