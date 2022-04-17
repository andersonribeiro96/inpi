package com.inpi.verify.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Titular {


    @XmlAttribute
    public String pais;

    @XmlAttribute
    public String uf;


}
