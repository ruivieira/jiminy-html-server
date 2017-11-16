package com.redhat.analytics.jiminy.htmlserver.service;

import com.redhat.analytics.jiminy.htmlserver.model.RatingsDAO;
import java.util.List;

public interface RatingService {
    interface ValidationRules {
        int max();

        int min();
    }

    // Validation Rules. Plan on moving this somewhere else but for here its
    // here.
    enum ValidUser implements ValidationRules {
        USERNAME {
            public int max() {
                return 20;
            }

            public int min() {
                return 5;
            }
        },
        PASSWORD {
            public int max() {
                return 10;
            }

            public int min() {
                return 5;
            }
        };
    }

    RatingsDAO create(RatingsDAO user);

    RatingsDAO delete(String id);

    List<RatingsDAO> findAll();

    RatingsDAO findById(String id);

    RatingsDAO update(RatingsDAO users);

    void deleteAll();

    RatingsDAO findByUsername(String username);

    void delete(RatingsDAO users);
}
