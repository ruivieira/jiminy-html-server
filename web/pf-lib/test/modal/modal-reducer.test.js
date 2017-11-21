import React from 'react';
import reducer from '../../modal/modalReducer';
import { MODAL } from '../../modal/modalConstants'
import { expect } from 'chai';


let initialState = {};
let mockMid = '';
describe('MODAL -> MODAL TESTS', () => {
  beforeEach(() => {
    initialState = {
      modals: {},
    };
    mockMid = '001';
  });

  it('Should return the initial state', () => {
    expect(reducer(undefined, {})).to.deep.equal(
      {
        modals: {},
      })
  });

  it('Should toggle the modal.', () => {
    const action = {type: MODAL.TOGGLE_MODAL, payload: mockMid};
    // Set modal id to false initially to test for toggling later
    initialState.modals[mockMid] = false;
    const actualState = reducer(initialState, action);
    const expectedState = {
      modals: {}
    };
    expectedState.modals[mockMid] = true;
    expect(actualState).to.deep.equal(expectedState)
  });

  it('Should add the modal', () => {
    const action = {type: MODAL.ADD_MODAL, payload: mockMid};
    const actualState = reducer(initialState, action);
    const expectedState = {
      modals: {}
    };
    expectedState.modals[mockMid] = false;
    expect(actualState).to.deep.equal(expectedState)
  });
});
