package grsu.course.app.entity;

import java.util.concurrent.atomic.AtomicLong;

public class Entity {
    private static AtomicLong id=new AtomicLong(1);

    public Entity(AtomicLong id) {
        this.id = id;
    }

    public AtomicLong getId() {
        return id;
    }

    public void setId(AtomicLong id) {
        this.id = id;
    }

    public static String createId (){
        return String.valueOf(id.getAndIncrement());
    }
}
