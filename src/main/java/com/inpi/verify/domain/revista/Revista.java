package com.inpi.verify.domain.revista;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Revista {

    @XmlElement(name = "processo")
    private List<Processo> processo;

    @XmlAttribute
    private int numero;

    @XmlAttribute
    private String data;

}
