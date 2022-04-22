package com.inpi.verify.domain.revista;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Despacho {

    @XmlAttribute
    private String codigo;
    @XmlAttribute
    private String nome;
    @XmlElement(name = "texto-complementar")
    private String texto_complementar;




}
