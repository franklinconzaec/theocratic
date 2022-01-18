package com.franklinconza.theocratic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Component
@ManagedBean
@ViewScoped
public class TelephoneMonitoringView implements Serializable {

    @Getter
    @Setter
    private Integer numberPhones;

    public TelephoneMonitoringView() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Carga inicial");
    }

    public void boton() {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<OperatorDTO> quote = restTemplate.getForObject(
                "http://localhost:8081/operator", OperatorDTO.class);
        System.out.println(quote.getId() + quote.getName());
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
