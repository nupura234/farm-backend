package com.app.farm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="plot")
public class Plot {



    @Id
    private String plotid;

    public String getPlotarea() {
        return plotarea;
    }

    public void setPlotarea(String plotarea) {
        this.plotarea = plotarea;
    }

    public String getPlotid() {
        return plotid;
    }

    public void setPlotid(String plotid) {
        this.plotid = plotid;
    }

    private String plotarea;

}
