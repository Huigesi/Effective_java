package section11;

import java.io.Serializable;
import java.util.Date;

public class Period {
    private final Date start;
    private final Date end;
    public Period(Date start, Date end) {
        /*if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "after" + end);
        }
        this.start=start;
        this.end=end;*/
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + "after" + end);
        }
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        public SerializationProxy(Date start, Date end) {
            this.start = start;
            this.end = end;
        }
        private static final long serialVersionUID=234098243823485285L;
    }

}
