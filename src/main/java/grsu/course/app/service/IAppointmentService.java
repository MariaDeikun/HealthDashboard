package grsu.course.app.service;

import java.time.LocalDate;

public interface IAppointmentService {
    void setCause(String cause);
    void setTimeOfApp(String timeOfApp);
    void setDateOfApp(LocalDate dateOfApp);
}
