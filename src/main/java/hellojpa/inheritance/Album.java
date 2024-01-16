package hellojpa.inheritance;

import javax.persistence.*;

@Entity
public class Album extends Item{
    private String artist;

}
