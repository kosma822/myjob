package it.gamesandapps.myjob.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String idUser;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
    private String birthDate;
    private List<Review> reviews = null;
    private String reviewsCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param reviews
     * @param phone
     * @param email
     * @param address
     * @param name
     * @param surname
     * @param idUser
     * @param birthDate
     * @param reviewsCount
     */
    public User(String idUser, String name, String surname, String address, String phone, String email, String birthDate, List<Review> reviews, String reviewsCount) {
        super();
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
        this.reviews = reviews;
        this.reviewsCount = reviewsCount;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(String reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}