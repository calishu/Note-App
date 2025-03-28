package dev.calishu.planetic.main.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data
@Table(name="noteapp")
public class Database {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column private String text;
    @Column private Integer date;
    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getDate() { return date; }
    public void setDate(Integer date) { this.date = date; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

}