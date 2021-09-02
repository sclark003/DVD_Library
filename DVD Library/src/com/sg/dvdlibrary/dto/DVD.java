package com.sg.dvdlibrary.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DVD {

    private enum MPAA {
        G, PG, PG13, R, NC17
    }


    private String title;
    private LocalDate releaseDate;
    private MPAA mpaaRating;
    private String directorName;
    private String studio;
    private String userRating;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getReleaseDate() {
        return releaseDate.toString();
    }

    public void setReleaseDate(String newReleaseDate) {
        LocalDate date = LocalDate.parse(newReleaseDate);
        this.releaseDate = date;
    }

    public String getMpaaRating() {
        return mpaaRating.toString();
    }

    public void setMpaaRating(String newMpaaRatingString) {
        MPAA newMpaaRating = MPAA.valueOf(newMpaaRatingString);
        this.mpaaRating = newMpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String newDirectorName) {
        this.directorName = newDirectorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String newStudio) {
        this.studio = newStudio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String newUserRating) {
        this.userRating = newUserRating;
    }

}
