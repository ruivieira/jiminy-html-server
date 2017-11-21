import { MODAL } from "./modalConstants"

export function toggleModal(mid){
  return {
    type: MODAL.TOGGLE_MODAL,
    payload: mid
  };
}

export function addModal(mid){
  return {
    type: MODAL.ADD_MODAL,
    payload: mid
  };
}

export function handleAddModal(mid){
  return (dispatch) => {
    dispatch(addModal(mid));
  };
}