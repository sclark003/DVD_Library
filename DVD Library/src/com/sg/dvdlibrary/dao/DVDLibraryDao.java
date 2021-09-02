package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;

import java.util.List;

public interface DVDLibraryDao {
    /**
     * Adds the given DVD to the library and associates it with the given
     * title. If there is already a DVD associated with the given
     * title it will return that DVD object, otherwise it will
     * return null.
     *
     * @param title title of DVD
     * @param dvd DVD to be added to the library
     * @return the DVD object previously associated with the given
     * title if it exists, null otherwise
     * @throws DVDLibraryException
     */
    DVD addDVD(String title, DVD dvd)
            throws DVDLibraryDaoException;

    /**
     * Removes from the library the DVD associated with the given title.
     * Returns the DVD object that is being removed or null if
     * there is no DVD associated with the given title
     *
     * @param title title of DVD to be removed
     * @return DVD object that was removed or null if no DVD
     * was associated with the given title
     * @throws DVDLibraryDaoException
     */
    DVD removeDVD(String title)
            throws DVDLibraryDaoException;

    /**
     * Updates the DVD associated with the given title in the library.
     * Returns the updated DVD object or null if
     * there is no DVD associated with the given title
     *
     * @param title title of DVD to be removed
     * @param dvd updated DVD object
     * @return DVD object that was updated or null if no DVD
     * was associated with the given title
     * @throws DVDLibraryDaoException
     */
    DVD updateDVD(String title, DVD dvd)
            throws DVDLibraryDaoException;

    /**
     * Returns a List of all DVDs on the roster.
     *
     * @return DVD List containing all DVDs in the library.
     * @throws DVDLibraryDaoException
     */
    List<DVD> getAllDVDs()
            throws DVDLibraryDaoException;

    /**
     * Returns the student object associated with the given title.
     * Returns null if no such DVD exists
     *
     * @param title title of the DVD to retrieve
     * @return the DVD object associated with the given title,
     * null if no such DVD exists
     * @throws DVDLibraryDaoException
     */
    DVD getDVD(String title)
            throws DVDLibraryDaoException;

}