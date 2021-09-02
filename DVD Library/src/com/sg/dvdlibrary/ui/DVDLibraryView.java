package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;

import java.time.LocalDate;
import java.util.List;

public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    // ----- Menu -------------------------------------------------------------------
    public int printMenuAndGetSelection() {
        io.print("______________________");
        io.print("Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Update a DVD");
        io.print("4. List DVDs in Library");
        io.print("5. Display a DVD");
        io.print("6. Exit");
        io.print("______________________");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public String getTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public boolean checkTitleNull(DVD dvdRecord) {
        if(dvdRecord == null){
            io.print("DVD not found in library.\n");
            return false;
        }else{
            return true;
        }
    }

    // ----- Add DVD ----------------------------------------------------------------
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }
    public void displayCreateSuccessBanner() {
        io.print("DVD successfully created. Please hit enter to continue.");
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please Enter DVD Title:");
        String releaseDate = io.readString("Please Enter DVD Release Date (yyyy-mm-dd):");
        String mpaaRating = io.readString("Please Enter DVD MPAA Rating (G/PG/PG13/R/NC17):");
        String directorName = io.readString("Please Enter DVD Director Name:");
        String studio = io.readString("Please Enter DVD Studio:");
        String userRating = io.readString("Please Enter DVD User Rating:");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }

    // ----- Remove DVD -------------------------------------------------------------
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }
    public void displayRemoveSuccess(DVD dvdRecord) {
        io.print("DVD successfully removed. Please hit enter to continue.");
    }

    // ----- Update DVD -------------------------------------------------------------
    public void displayUpdateDVDBanner() {
        io.print("=== Update DVD ===");
    }

    public String displayUpdateAnotherField() {
        String response = io.readString("Update another field? (y/n)");
        return response;
    }

    public void displayUpdateSuccess(DVD dvdRecord) {
        io.print("DVD successfully updated. Please hit enter to continue.");
    }

    public int chooseDVDField() {
        io.print("______________________");
        io.print("DVD Fields:");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. MPAA Rating");
        io.print("4. Director Name");
        io.print("5. Studio");
        io.print("6. User Rating");
        io.print("7. Skip");
        io.print("______________________");

        return io.readInt("Please select field to update from the above choices.", 1, 7);
    }

    public DVD updateField(int fieldSelection, DVD dvd){
        switch (fieldSelection) {
            case 1:
                String title = io.readString("Please Enter new DVD Title:");
                dvd.setTitle(title);
                break;
            case 2:
                String releaseDate = io.readString("Please Enter new DVD Release Date (yyyy-mm-dd):");
                dvd.setReleaseDate(releaseDate);
                break;
            case 3:
                String mpaaRating = io.readString("Please Enter new DVD MPAA Rating (G/PG/PG13/R/NC17):");
                dvd.setMpaaRating(mpaaRating);
                break;
            case 4:
                String directorName = io.readString("Please Enter new DVD Director Name:");
                dvd.setDirectorName(directorName);
                break;
            case 5:
                String studio = io.readString("Please Enter new DVD Studio:");
                dvd.setStudio(studio);
                break;
            case 6:
                String userRating = io.readString("Please Enter new DVD User Rating:");
                dvd.setUserRating(userRating);
                break;
            case 7:
                break;
            default:
                displayUnknownCommandBanner();
        }
        return dvd;
    }

    // ----- List DVDs --------------------------------------------------------------
    public void displayListDVDsBanner() {
        io.print("=== List DVDs ===");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print("Title: " + currentDVD.getTitle());
            io.print("Release Date: " + currentDVD.getReleaseDate());
            io.print("MPAA Rating " + currentDVD.getMpaaRating());
            io.print("Director Name: " + currentDVD.getDirectorName());
            io.print("Studio: " + currentDVD.getStudio());
            io.print("User Rating: " + currentDVD.getUserRating());
            io.print("\n");
        }
        io.readString("Please hit enter to continue.");
    }

    // ----- Display DVD ------------------------------------------------------------
    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public void displayDVD(DVD currentDVD) {
        io.print("Title: " + currentDVD.getTitle());
        io.print("Release Date: " + currentDVD.getReleaseDate());
        io.print("MPAA Rating " + currentDVD.getMpaaRating());
        io.print("Director Name: " + currentDVD.getDirectorName());
        io.print("Studio: " + currentDVD.getStudio());
        io.print("User Rating: " + currentDVD.getUserRating());
        io.readString("\nPlease hit enter to continue.");
    }

    // ----- Unknown Command ---------------------------------------------------------
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command.");
    }

    // ----- Exit -------------------------------------------------------------------
    public void displayExitMessage() {
        io.print("Exiting...");
    }

    // ----- Error -------------------------------------------------------------------
    public void displayErrorMessage(String errorMsg) {
        io.print("ERROR");
        io.print(errorMsg);
    }
}