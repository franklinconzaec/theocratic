package com.franklinconza.theocratic.ministry.call;

import com.franklinconza.theocratic.ministry.state.StateFindResponse;
import com.franklinconza.theocratic.ministry.state.StateService;
import com.franklinconza.theocratic.security.user.UserFindResponse;
import com.franklinconza.theocratic.security.user.UserService;
import com.franklinconza.theocratic.utils.Mapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@RequiredArgsConstructor
public class CallListView {

    private final CallService callService;
    private final UserService userService;
    private final StateService stateService;
    private final Mapper mapper;

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
    private CallFindResponse selectedCall;

    @Getter
    @Setter
    private Integer selectedUpdateConductorId;

    @Getter
    @Setter
    private Integer selectedUpdatePublisherId;

    @Getter
    @Setter
    private UserFindResponse publisher;

    @Getter
    private List<String> sections;

    @Getter
    private List<UserFindResponse> conductors;

    @Getter
    private List<UserFindResponse> publishers;

    @Getter
    private List<StateFindResponse> states;

    @Getter
    private List<CallFindResponse> calls;

    @PostConstruct
    public void init() {
        selectedCall = new CallFindResponse();
        sections = new ArrayList<>();
        conductors = userService.findUserByRole(6);
        publishers = userService.findUserByRole(3);
        states = stateService.findAll();
        calls = new ArrayList<>();

        sections.add("MAÑANA");
        sections.add("TARDE");
        sections.add("NOCHE");
    }

    public void find() {
        calls = new ArrayList<CallFindResponse>();

        if (date != null && section.compareTo("") != 0) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = format.format(date);

            calls.addAll(callService.findCallByDateAndSection(date, section));
        }
    }

    public void deleteCall() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Llamada borrada"));
        //PrimeFaces.current().ajax().update("form_table:messages", "form_table:dt-calls");
    }

    public void updateCall() {
        CallUpdateRequest callUpdateRequest = mapper.map(selectedCall, CallUpdateRequest.class);
        callService.update(callUpdateRequest);
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
