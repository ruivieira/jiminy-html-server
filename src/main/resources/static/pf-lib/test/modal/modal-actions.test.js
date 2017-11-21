import React from 'react';
import { expect } from 'chai';
import * as actions from '../../modal/modalActions'
import { MODAL } from '../../modal/modalConstants'
import configureMockStore from 'redux-mock-store'
import thunk from 'redux-thunk'

describe('MODAL -> ACTION TESTS', () => {
  it('Should toggle modal.', () => {
    const expectedAction = {
      type: MODAL.TOGGLE_MODAL,
      payload: '001'
    };
    expect(actions.toggleModal('001')).to.deep.equal(expectedAction)
  });

  it('Should add modal.', () => {
    const expectedAction = {
      type: MODAL.ADD_MODAL,
      payload: '001'
    };
    expect(actions.addModal('001')).to.deep.equal(expectedAction)
  });

  const middlewares = [thunk];
  const mockStore = configureMockStore(middlewares);

  it('Should handle add modal.', () => {
    const mid = '001';
    const expectedAction = {
      type: MODAL.ADD_MODAL,
      payload: mid
    };

    const store = mockStore({});
    store.dispatch(actions.handleAddModal(mid));
    expect(store.getActions()).to.deep.equal([expectedAction]);

  });
});