package com.example.reportingloggingservice.subscriber;


import com.example.reportingloggingservice.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Receiver {

    private static List<Product> marketDataFrmExOne = new ArrayList<>();
    private static List<Product> marketDataFrmExTwo = new ArrayList<>();
    Logger logger = LoggerFactory.getLogger(Receiver.class);
    ObjectMapper objectMapper = new ObjectMapper();

    public void marketDataFromExchangeOne(String message) throws JsonProcessingException {
        Product[] productList = objectMapper.readValue(message, Product[].class);
        marketDataFrmExOne = Arrays.asList(productList);
        logger.info("Consumed message from exchange one {}",marketDataFrmExOne);
    }

}
