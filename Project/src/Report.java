
import java.io.Serializable;
import java.util.*;

public class Report extends Text{

    public Report() {
        super();
    }

    public Report(String reportTitle, String reportText) {
        super(reportTitle, reportText);
    }

    public Report(String reportTitle) {
        super(reportTitle);
    }
}