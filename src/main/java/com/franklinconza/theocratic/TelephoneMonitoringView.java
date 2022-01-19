package com.franklinconza.theocratic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
public class TelephoneMonitoringView {

    private RestTemplate restTemplate;

    @Getter
    @Setter
    private Integer numberPhones;

    @Getter
    private ArrayList<OperatorDTO> operators = new ArrayList<>();

    //@Autowired
    public TelephoneMonitoringView() {
        //this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void init() {
        System.out.println("Carga inicial");
    }

    public void boton() {
        restTemplate = new RestTemplate();
        ResponseEntity<List<OperatorDTO>> response = restTemplate.exchange(
                "http://localhost:8081/operator", HttpMethod.GET, null, new ParameterizedTypeReference<List<OperatorDTO>>() {
                });
        operators.addAll(response.getBody());
        System.out.println(response.getBody().get(0).getName());
    }

/*
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
*/

}
