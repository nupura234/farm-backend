package com.app.farm.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="plantation")
public class Plantation {

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "plot_plotid")
    private  Plot plot;

    @Id
    private String plotid = plot.getPlotid();

    private String treename;
    private int treecount;
    private int date;

}
