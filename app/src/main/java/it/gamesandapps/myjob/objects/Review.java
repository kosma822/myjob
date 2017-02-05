package it.gamesandapps.myjob.objects;

import java.util.HashMap;
import java.util.Map;

public class Review {

    private String idReview;
    private String idUser;
    private String idCompany;
    private String vote;
    private Company company;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Review() {
    }

    /**
     *
     * @param idCompany
     * @param idReview
     * @param vote
     * @param company
     * @param idUser
     */
    public Review(String idReview, String idUser, String idCompany, String vote, Company company) {
        super();
        this.idReview = idReview;
        this.idUser = idUser;
        this.idCompany = idCompany;
        this.vote = vote;
        this.company = company;
    }

    public String getIdReview() {
        return idReview;
    }

    public void setIdReview(String idReview) {
        this.idReview = idReview;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
