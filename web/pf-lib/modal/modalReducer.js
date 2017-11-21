import { MODAL } from "./modalConstants"

const initialState = {
  modals: {}
};

const modalReducer = function(state = initialState, action){
  switch(action.type){
    case MODAL.TOGGLE_MODAL: {
      let mid = action.payload;
      state = {...state};
      state.modals = {...state.modals};
      state.modals[mid] = (state.modals[mid] === false);
      return state;
    }
    case MODAL.ADD_MODAL: {
      let mid = action.payload;
      state = {...state};
      state.modals = {...state.modals};
      state.modals[mid] = false;
      return state;
    }
    default:
      return state;
  }
};

export default modalReducer
