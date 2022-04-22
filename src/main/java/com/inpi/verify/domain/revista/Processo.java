package com.inpi.verify.domain.revista;



import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Processo {

    @XmlElement(name = "despachos")
    private Despachos despachos;
    @XmlElement(name = "titulares")
    private Titulares titulares;
    @XmlElement(name = "procurador")
    private String procurador;
    @XmlAttribute
    private String numero;

}
