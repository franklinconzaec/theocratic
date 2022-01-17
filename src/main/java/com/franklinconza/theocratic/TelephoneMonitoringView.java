package com.franklinconza.theocratic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@Component
@ManagedBean
@ViewScoped
public class TelephoneMonitoringView implements Serializable {

    @Getter @Setter
    private Integer numberPhones;

}
