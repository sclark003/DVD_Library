package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDLibraryDao dao;
    //private UserIO io = new UserIOConsoleImpl();

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        updateDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        displayDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        boolean success = view.checkTitleNull(removedDVD);
        if (success == true){
            view.displayRemoveSuccess(removedDVD);
        }
    }

    private void updateDVD() throws DVDLibraryDaoException {
        boolean keepUpdating = true;
        view.displayUpdateDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        boolean success = view.checkTitleNull(dvd);

        if (success == true) {
            while (keepUpdating == true) {
                int fieldSelection = view.chooseDVDField();
                view.updateField(fieldSelection, dvd);
                String response = view.displayUpdateAnotherField();
                System.out.println("A:" + response);
                if (response.equals("y") || response.equals("Y") || response.equals("yes") || response.equals("Yes")) {
                    System.out.println("B:" + response);
                    keepUpdating = true;
                } else {
                    keepUpdating = false;
                }
            }
            dao.updateDVD(title, dvd);
            view.displayUpdateSuccess(dvd);
        }
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayListDVDsBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void displayDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD currentDVD = dao.getDVD(title);
        boolean success = view.checkTitleNull(currentDVD);
        if (success == true){
            view.displayDVD(currentDVD);
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

}