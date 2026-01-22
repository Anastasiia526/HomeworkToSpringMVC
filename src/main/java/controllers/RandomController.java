package controllers;

import model.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping(value = "/random")
public class RandomController {

    private final Random random = new Random();

    @GetMapping(value = "/uuid")
    @ResponseBody
    public Map<String, String> getRandomUuid() {
        Map<String, String> map = new HashMap<>();
        map.put("uuid", UUID.randomUUID().toString());
        return map;
    }

    @RequestMapping(value = "/exchange")
    @ResponseBody
    public Map<Currency, Double> randomCurrencyExchangeRate() {
        Map<Currency, Double> map = new HashMap<>();
        Currency usd = new Currency("USD");
        Currency uah = new Currency("UAH");
        Currency eur = new Currency("EUR");
        map.put(uah, getRandomDouble());
        map.put(usd, getRandomDouble());
        map.put(eur, getRandomDouble());
        return map;
    }

    @GetMapping(value = "/exchange/{currency}")
    @ResponseBody
    public Map<String, Object> getRandomCurrency(@PathVariable("currency") String currency) {
        Map<String, Object> map = new HashMap<>();
        map.put("currency", currency.toUpperCase());
        map.put("rate", getRandomDouble());
        return map;
    }

    public Double getRandomDouble() {
        return random.nextDouble();
    }
}
