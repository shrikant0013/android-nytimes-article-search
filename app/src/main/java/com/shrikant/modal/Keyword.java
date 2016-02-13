
package com.shrikant.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Keyword {

    @SerializedName("rank")
    @Expose
    private String rank;
    @SerializedName("is_major")
    @Expose
    private String isMajor;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * 
     * @return
     *     The rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * 
     * @param rank
     *     The rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * 
     * @return
     *     The isMajor
     */
    public String getIsMajor() {
        return isMajor;
    }

    /**
     * 
     * @param isMajor
     *     The is_major
     */
    public void setIsMajor(String isMajor) {
        this.isMajor = isMajor;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
