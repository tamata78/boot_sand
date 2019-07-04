package com.example.boot_sand.controler;

import java.util.ArrayList;
import java.util.List;

import com.example.boot_sand.entity.Item;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * XML生成用のクラス
 * 
 * @author tamata78
 */
@JacksonXmlRootElement(localName = "wrapper")
public class XmlWrapper {
    @JacksonXmlElementWrapper(localName = "xml")
    @JsonProperty("item")
    public List<Item> itemList = new ArrayList<>();

    public XmlWrapper(List<Item> items) {
    	itemList.addAll(items);

    }

}
