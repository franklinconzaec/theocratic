package com.franklinconza.theocratic;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@ManagedBean
@ViewScoped
public class CallListView {

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private String section;

    @Getter
    @Setter
    private int selectedFindConductorId;

    @Getter
    @Setter
    private CallDto selectedCall;

    @Getter
    @Setter
    private Integer selectedUpdateConductorId;

    @Getter
    @Setter
    private Integer selectedUpdatePublisherId;

    @Getter
    @Setter
    private UserDto publisher;

    @Getter
    private ArrayList<String> sections;

    @Getter
    private ArrayList<UserDto> conductors;

    @Getter
    private ArrayList<UserDto> publishers;

    @Getter
    private ArrayList<StateDto> states;

    @Getter
    private ArrayList<CallDto> calls;

    private RestTemplate restTemplate;
    private Map<String, String> parameters;
    private ResponseEntity<List<CallDto>> responseCall;
    private ResponseEntity<List<StateDto>> responseState;
    private ResponseEntity<List<UserDto>> responseConductor;
    private ResponseEntity<List<UserDto>> responsePublisher;

    public CallListView() {
    }

    @PostConstruct
    public void init() {
        selectedCall = new CallDto();
        sections = new ArrayList<>();
        conductors = new ArrayList<>();
        publishers = new ArrayList<>();
        states = new ArrayList<>();
        calls = new ArrayList<>();
        restTemplate = new RestTemplate();
        parameters = new HashMap<String, String>();

        parameters.put("role", "6");
        responseConductor = restTemplate.exchange(
                "http://localhost:8081/user/role?role={role}",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDto>>() {
                }, parameters);
        conductors.addAll(responseConductor.getBody());

        parameters = new HashMap<String, String>();
        parameters.put("role", "3");
        responsePublisher = restTemplate.exchange(
                "http://localhost:8081/user/role?role={role}",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDto>>() {
                }, parameters);
        publishers.addAll(responsePublisher.getBody());

        responseState = restTemplate.exchange(
                "http://localhost:8081/state",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<StateDto>>() {
                });
        states.addAll(responseState.getBody());

        sections.add("MAÑANA");
        sections.add("TARDE");
        sections.add("NOCHE");
    }

    public void find() {
        calls = new ArrayList<CallDto>();
        parameters = new HashMap<String, String>();

        if (date != null && section.compareTo("") != 0 && selectedFindConductorId != 0) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            parameters.put("date", dateString);
            parameters.put("section", section);
            parameters.put("conductorId", Integer.toString(selectedFindConductorId));

            responseCall = restTemplate.exchange(
                    "http://localhost:8081/call/dateandsectionandconductor?date={date}&section={section}&conductorId={conductorId}",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<CallDto>>() {
                    }, parameters);
            calls.addAll(responseCall.getBody());
        } else if (date != null && section.compareTo("") != 0 && selectedFindConductorId == 0) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            parameters.put("date", dateString);
            parameters.put("section", section);

            responseCall = restTemplate.exchange(
                    "http://localhost:8081/call/dateandsection?date={date}&section={section}",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<CallDto>>() {
                    }, parameters);
            calls.addAll(responseCall.getBody());
        } else if (date != null && section.compareTo("") == 0 && selectedFindConductorId == 0) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);
            parameters.put("date", dateString);

            responseCall = restTemplate.exchange(
                    "http://localhost:8081/call/date?date={date}",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<CallDto>>() {
                    }, parameters);
            calls.addAll(responseCall.getBody());
        } else if (date == null && section.compareTo("") == 0 && selectedFindConductorId != 0) {
            parameters.put("conductorId", Integer.toString(selectedFindConductorId));

            responseCall = restTemplate.exchange(
                    "http://localhost:8081/call/conductorwithoutpublisherorstate?conductorId={conductorId}",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<CallDto>>() {
                    }, parameters);
            calls.addAll(responseCall.getBody());
        }
    }

    public void deleteCall() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Llamada borrada"));
        PrimeFaces.current().ajax().update("form_table:messages", "form_table:dt-calls");
    }

    public void updateCall() {
        System.out.println(selectedCall.getId());
        System.out.println(selectedCall.getConductorId());
        System.out.println(selectedCall.getPublisherId());
        System.out.println(selectedCall.getStateId());
        System.out.println(selectedCall.getObservation());

        CallUpdateDto callUpdateDto = new CallUpdateDto();
        callUpdateDto.setId(selectedCall.getId());
        callUpdateDto.setConductorId(selectedCall.getConductorId());
        callUpdateDto.setPublisherId(selectedCall.getPublisherId());
        callUpdateDto.setStateId(selectedCall.getStateId());
        callUpdateDto.setObservation(selectedCall.getObservation());

        parameters = new HashMap<String, String>();
//        parameters.put("conductorId", Integer.toString(selectedFindConductorId));
//
        restTemplate.put("http://localhost:8081/call", callUpdateDto, CallDto.class);
        find();
//                .exchange(
//                "http://localhost:8081/call",
//                HttpMethod.PUT, null, new ParameterizedTypeReference<List<CallDto>>() {
//                }, parameters);
//        calls.addAll(responseCall.getBody());

        //        if (this.selectedProduct.getCode() == null) {
//            this.selectedProduct.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
//            this.products.add(this.selectedProduct);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
//        }
//        else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Llamada actualizada"));
//        }

        PrimeFaces.current().executeScript("PF('manageCallDialog').hide()");
        PrimeFaces.current().ajax().update("form_table:messages", "form:dt-calls");
    }
/*
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
*/

}
