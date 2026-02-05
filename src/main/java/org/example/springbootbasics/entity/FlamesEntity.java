package org.example.springbootbasics.entity;

import jakarta.persistence.*;
import org.hibernate.query.NativeQuery;

@Entity
@Table(name = "flames")
public class FlamesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boyName;
    private String girlName;
    private String result;

    public long getId(){
        return id;
    }

    public String getBoyName(){
        return boyName;
    }

    public void setBoyName(String boyName){
        this.boyName = boyName;
    }

    public String getGirlName(){
        return girlName;
    }

    public void setGirlName(String gn){
        this.girlName = gn;
    }

    public String getResult(){
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }
}
