package com.inpi.verify.domain.revista;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Despachos {

    @XmlElement(name = "despacho")
    public Despacho despacho;

}
