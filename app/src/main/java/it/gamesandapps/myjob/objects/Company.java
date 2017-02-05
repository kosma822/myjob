package it.gamesandapps.myjob.objects;

import java.util.HashMap;
import java.util.Map;

public class Company {

    private String idCompany;
    private String idCompanyCategory;
    private String email;
    private String name;
    private String urlImg;
    private String urlSquareLogo;
    private String piva;
    private String address;
    private String city;
    private String cap;
    private String phone;
    private String latitude;
    private String longitude;
    private String reviewsAverage;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Company() {
    }

    /**
     *
     * @param phone
     * @param idCompany
     * @param urlImg
     * @param cap
     * @param reviewsAverage
     * @param city
     * @param idCompanyCategory
     * @param email
     * @param address
     * @param name
     * @param longitude
     * @param latitude
     * @param urlSquareLogo
     * @param piva
     */
    public Company(String idCompany, String idCompanyCategory, String email, String name, String urlImg, String urlSquareLogo, String piva, String address, String city, String cap, String phone, String latitude, String longitude, String reviewsAverage) {
        super();
        this.idCompany = idCompany;
        this.idCompanyCategory = idCompanyCategory;
        this.email = email;
        this.name = name;
        this.urlImg = urlImg;
        this.urlSquareLogo = urlSquareLogo;
        this.piva = piva;
        this.address = address;
        this.city = city;
        this.cap = cap;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reviewsAverage = reviewsAverage;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getIdCompanyCategory() {
        return idCompanyCategory;
    }

    public void setIdCompanyCategory(String idCompanyCategory) {
        this.idCompanyCategory = idCompanyCategory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getUrlSquareLogo() {
        return urlSquareLogo;
    }

    public void setUrlSquareLogo(String urlSquareLogo) {
        this.urlSquareLogo = urlSquareLogo;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getReviewsAverage() {
        return reviewsAverage;
    }

    public void setReviewsAverage(String reviewsAverage) {
        this.reviewsAverage = reviewsAverage;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
