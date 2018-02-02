import { createStore, combineReducers, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import messageReducer from 'redux';
import modalReducer from 'redux';
import movieReducer from './movieRating/movieReducers';
import addRatingReducer from './addRating/addRatingReducer';
import { createForms } from 'react-redux-form';
import { initialFormUserState } from './addRating/addRatingReducer.js'
import { initialRatingsFormUserState } from './movieRating/movieReducers.js'


export default createStore(
  combineReducers({
    modalReducer,
    messageReducer,
    movieReducer,
    addRatingReducer,
    ...createForms({
      display: initialFormUserState,
      ratings: initialRatingsFormUserState,
    })
  }),
  applyMiddleware(thunk)
);
