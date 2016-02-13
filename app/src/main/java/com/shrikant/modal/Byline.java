
package com.shrikant.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Byline {

    @SerializedName("person")
    @Expose
    private List<Person> person = new ArrayList<Person>();
    @SerializedName("original")
    @Expose
    private String original;

    /**
     * 
     * @return
     *     The person
     */
    public List<Person> getPerson() {
        return person;
    }

    /**
     * 
     * @param person
     *     The person
     */
    public void setPerson(List<Person> person) {
        this.person = person;
    }

    /**
     * 
     * @return
     *     The original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * 
     * @param original
     *     The original
     */
    public void setOriginal(String original) {
        this.original = original;
    }

}
