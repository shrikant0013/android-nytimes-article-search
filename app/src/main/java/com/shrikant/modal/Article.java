package com.shrikant.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Article {
    public final static String TYPE = "type";
    public final static String IMAGE = "image";
    public final static String THUMBNAIL_TYPE = "thumbnail";
    public final static String NYTIMES_BASE_URI = "http://www.nytimes.com/";
    public final static String URL = "url";

    @SerializedName("web_url")
    @Expose
    public String webUrl;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("lead_paragraph")
    @Expose
    private String leadParagraph;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("print_page")
    @Expose
    private String printPage;
    @SerializedName("blog")
    @Expose
    private List<Object> blog = new ArrayList<Object>();
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("multimedia")
    @Expose
    private List<Multimedium> multimedia = new ArrayList<Multimedium>();
    @SerializedName("headline")
    @Expose
    public Headline headline;
    @SerializedName("keywords")
    @Expose
    private List<Keyword> keywords = new ArrayList<Keyword>();
    @SerializedName("pub_date")
    @Expose
    private String pubDate;
    @SerializedName("document_type")
    @Expose
    private String documentType;
    @SerializedName("news_desk")
    @Expose
    private String newsDesk;
    @SerializedName("section_name")
    @Expose
    private String sectionName;
    @SerializedName("subsection_name")
    @Expose
    private String subsectionName;
//    @SerializedName("byline")
//    @Expose
//    private Byline byline;
    @SerializedName("type_of_material")
    @Expose
    private String typeOfMaterial;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("word_count")
    @Expose
    private String wordCount;
    @SerializedName("slideshow_credits")
    @Expose
    private Object slideshowCredits;

    /**
     * 
     * @return
     *     The webUrl
     */
    public String getWebUrl() {
        return webUrl;
    }

    /**
     * 
     * @param webUrl
     *     The web_url
     */
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    /**
     * 
     * @return
     *     The snippet
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * 
     * @param snippet
     *     The snippet
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     * 
     * @return
     *     The leadParagraph
     */
    public String getLeadParagraph() {
        return leadParagraph;
    }

    /**
     * 
     * @param leadParagraph
     *     The lead_paragraph
     */
    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    /**
     * 
     * @return
     *     The _abstract
     */
    public String getAbstract() {
        return _abstract;
    }

    /**
     * 
     * @param _abstract
     *     The abstract
     */
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    /**
     * 
     * @return
     *     The printPage
     */
    public String getPrintPage() {
        return printPage;
    }

    /**
     * 
     * @param printPage
     *     The print_page
     */
    public void setPrintPage(String printPage) {
        this.printPage = printPage;
    }

    /**
     * 
     * @return
     *     The blog
     */
    public List<Object> getBlog() {
        return blog;
    }

    /**
     * 
     * @param blog
     *     The blog
     */
    public void setBlog(List<Object> blog) {
        this.blog = blog;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The multimedia
     */
    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    /**
     * 
     * @param multimedia
     *     The multimedia
     */
    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * 
     * @return
     *     The headline
     */
    public Headline getHeadline() {
        return headline;
    }

    /**
     * 
     * @param headline
     *     The headline
     */
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    /**
     * 
     * @return
     *     The keywords
     */
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * 
     * @param keywords
     *     The keywords
     */
    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    /**
     * 
     * @return
     *     The pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * 
     * @param pubDate
     *     The pub_date
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * 
     * @return
     *     The documentType
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * 
     * @param documentType
     *     The document_type
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * 
     * @return
     *     The newsDesk
     */
    public String getNewsDesk() {
        return newsDesk;
    }

    /**
     * 
     * @param newsDesk
     *     The news_desk
     */
    public void setNewsDesk(String newsDesk) {
        this.newsDesk = newsDesk;
    }

    /**
     * 
     * @return
     *     The sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * 
     * @param sectionName
     *     The section_name
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * 
     * @return
     *     The subsectionName
     */
    public String getSubsectionName() {
        return subsectionName;
    }

    /**
     * 
     * @param subsectionName
     *     The subsection_name
     */
    public void setSubsectionName(String subsectionName) {
        this.subsectionName = subsectionName;
    }

//    /**
//     *
//     * @return
//     *     The byline
//     */
//    public Byline getByline() {
//        return byline;
//    }
//
//    /**
//     *
//     * @param byline
//     *     The byline
//     */
//    public void setByline(Byline byline) {
//        this.byline = byline;
//    }

    /**
     * 
     * @return
     *     The typeOfMaterial
     */
    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    /**
     * 
     * @param typeOfMaterial
     *     The type_of_material
     */
    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The wordCount
     */
    public String getWordCount() {
        return wordCount;
    }

    /**
     * 
     * @param wordCount
     *     The word_count
     */
    public void setWordCount(String wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * 
     * @return
     *     The slideshowCredits
     */
    public Object getSlideshowCredits() {
        return slideshowCredits;
    }

    /**
     * 
     * @param slideshowCredits
     *     The slideshow_credits
     */
    public void setSlideshowCredits(Object slideshowCredits) {
        this.slideshowCredits = slideshowCredits;
    }

    public String getArticleThumbnailUrl() {
        String thumbnailUrl = "";

        for (Multimedium m : this.getMultimedia()) {
            if (m.getType().equals(IMAGE) && m.getSubtype().equals("xlarge")) {
                thumbnailUrl = NYTIMES_BASE_URI + m.getUrl();
                break;
            }
        }
        return thumbnailUrl;
    }

}
