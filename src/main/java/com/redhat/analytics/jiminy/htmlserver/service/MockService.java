package com.redhat.analytics.jiminy.htmlserver.service;

import com.redhat.analytics.jiminy.htmlserver.model.ReportDAO;
import com.redhat.analytics.jiminy.htmlserver.model.UserDAO;

public interface MockService {
    ReportDAO findAll();

    UserDAO findAllUsers();
}
