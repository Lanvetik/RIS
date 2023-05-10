package LR6.entity;

import java.io.Serializable;

public class Phonetics implements Serializable {
    private long id;
    private String performer;
    private String album;

    public Phonetics() {
    }

    public Phonetics(long id, String performer, String album) {
        this.id = id;
        this.performer = performer;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}