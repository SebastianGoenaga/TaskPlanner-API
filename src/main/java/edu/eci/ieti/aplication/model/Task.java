package edu.eci.ieti.aplication.model;



public class Task{

    private User owner;
    private String responsable;
    private String description;
    private String date;
    private statusEnum status;

    public Task(){
    }

    public Task(User owner, String responsable, String description, String date, statusEnum status) {
        this.owner = owner;
        this.responsable = responsable;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public statusEnum getStatus() {
        return status;
    }

    public void setStatus(statusEnum status) {
        this.status = status;
    }

    

}