package APP;

public class Music {
    private int id;
    private String filename;
    private String album;
    private String autor;
    private String genero;
    private Integer classif;


    public Music(Integer id, String file, String alb, String aut, String genre){
        this.id = id;
        this.filename = file;
        this.album = alb;
        this.autor = aut;
        this.classif = 0;
        this.genero = genre;
    }

    public String getName(){
        return this.filename;
    }

    public String getAlbum(){
        return this.album;
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

    public String getGenero(){return this.genero;}

    public void setId(int i){
        this.id=i;
    }

    public void upVote(){
        this.classif++;
    }

    public void downVote(){
        this.classif--;
    }
}
