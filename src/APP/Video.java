package APP;

import java.util.ArrayList;

public class Video {
    private Integer id;
    private String filename;
    private Integer season;
    private String autor;
    private Integer classif;

    public Video(String file, String aut, String owner, Integer se){
        this.id = 0;
        this.filename = file;
        this.autor = aut;
        this.classif = 0;
        this.season = se;
    }

    public String getName(){
        return this.filename;
    }

    public String getAutor(){
        return this.autor;
    }

    public Integer getId(){
        return this.id;
    }

    public Integer getClassif(){
        return this.classif;
    }

    public Integer getSeason(){return this.season;}

    public void setId(Integer i){
        this.id=i;
    }

    public void setSeason(Integer i){this.season=i;}

    public void upVote(){
        this.classif++;
    }

    public void downVote(){
        this.classif--;
    }
}
