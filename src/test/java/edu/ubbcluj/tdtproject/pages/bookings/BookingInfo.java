package edu.ubbcluj.tdtproject.pages.bookings;

import java.util.Objects;

public class BookingInfo {
    public String name;
    public String location;
    public String deskLabel;
    public String date;
    public String time;

    public BookingInfo(String name, String location, String deskLabel, String date, String time) {
        this.name = name;
        this.location = location;
        this.deskLabel = deskLabel;
        this.date = date;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingInfo that = (BookingInfo) o;
        return name.equals(that.name) && location.equals(that.location) && deskLabel.equals(that.deskLabel) && date.equals(that.date) && time.equals(that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, deskLabel, date, time);
    }
}
