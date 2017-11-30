package com.redhat.analytics.jiminy.htmlserver.service;

import com.redhat.analytics.jiminy.htmlserver.model.ColumnHeader;
import com.redhat.analytics.jiminy.htmlserver.model.MovieDataSet;
import com.redhat.analytics.jiminy.htmlserver.model.ReportDAO;
import com.redhat.analytics.jiminy.htmlserver.model.UserDAO;
import com.redhat.analytics.jiminy.htmlserver.model.UserDataSet;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MockPGReportService implements MockService {

    public ReportDAO
    findAll(){
        return new ReportDAO("OK",
                Arrays.asList(
                    new ColumnHeader("id","ID"),
                    new ColumnHeader("movie","Movie Title"),
                    new ColumnHeader("year","Release Year") ),
                Arrays.asList(
                    new MovieDataSet("1","Detachment","2004"),
                    new MovieDataSet("2","Alexander","2011"),
                    new MovieDataSet("3","Black Hawk Down","2002"),
                    new MovieDataSet("4","Bourne Identity, The","2004"),
                    new MovieDataSet("5","Cast Away","2000"),
                    new MovieDataSet("6","Drive","2011"),
                    new MovieDataSet("7","Fargo","1996")
                ));
    }

    @Override
    public UserDAO findAllUsers() {
        return new UserDAO("OK",
                Arrays.asList(
                    new ColumnHeader("id","ID"),
                    new ColumnHeader("fname","First Name"),
                    new ColumnHeader("lname","Last Name") ),
                Arrays.asList(
                    new UserDataSet("1","John","Smith"),
                    new UserDataSet("1","Jacob","Jones"),
                    new UserDataSet("1","David","Taylor"),
                    new UserDataSet("1","Michael","Johnson"),
                    new UserDataSet("1","Richard","Jackson"),
                    new UserDataSet("1","Josh","Shaw"),
                    new UserDataSet("1","Christian","Lloyd"),
                    new UserDataSet("1","Lukas","Ellis")
                ));
    }
}
