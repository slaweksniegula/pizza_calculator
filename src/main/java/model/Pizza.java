package model;

import javax.persistence.*;

@Entity
@Table(name = "Pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private long id;
    @Column(name = "pizza_r")
    private int r;
    @Column(name = "crust_edge")
    private int crustEdge;
    @Column(name = "calculated_area")
    private double ingredientsPercentage;
    @Column(name = "user_email")
    String userEmail;

    public Pizza() {
    }

    public Pizza(int r, int crustEdge, double ingredientsPercentage, String userEmail) {
        this.r = r;
        this.crustEdge = crustEdge;
        this.ingredientsPercentage = ingredientsPercentage;
        this.userEmail = userEmail;
    }

    public static double calculateIngredientsPercentage(int r, int crustEdge) {
        double ingredientsRadius = r - crustEdge;
        double pizzasField = 3.141592 * (r * r);
        double cheeseField = 3.141592 * (ingredientsRadius * ingredientsRadius);
        double ingredientsPercentage = cheeseField / pizzasField * 100;
        return Math.round(ingredientsPercentage);
    }

    public void setIngredientsPercentage(double ingredientsPercentage) {
        this.ingredientsPercentage = calculateIngredientsPercentage(r, crustEdge);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getCrustEdge() {
        return crustEdge;
    }

    public void setCrustEdge(int crustEdge) {
        this.crustEdge = crustEdge;
    }

    public double getIngredientsPercentage() {
        return ingredientsPercentage;
    }

    public Long getId() {
        return id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
