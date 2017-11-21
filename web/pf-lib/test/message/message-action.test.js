import React from 'react';
import { expect } from 'chai';
import * as actions from '../../message/messageActions'
import { MESSAGE } from '../../message/messageConstants'

import configureMockStore from 'redux-mock-store'
import thunk from 'redux-thunk'

describe('MESSAGE -> SYNC ACTION TESTS', () => {

  it('Should create an action to set message visibility.', () => {
    const isVisible = true;
    const expectedAction = {
      type: MESSAGE.SET_VISIBLE,
      payload: isVisible
    };
    expect(actions.setVisible(true)).to.deep.equal(expectedAction)
  });

  it('Should create an action to set message.', () => {
    const message = "Test should complete successfully.";
    const type = "success";
    const payload = {
      message: message,
      messageType: type,
      icon: "ok",
    };

    const expectedAction = {
      type: MESSAGE.SET_MESSAGE,
      payload: payload
    };
    expect(actions.setMessage(message, type)).to.deep.equal(expectedAction)
  });

  it('Should create an action to clear message.', () => {
    const expectedAction = {
      type: MESSAGE.CLEAR_MESSAGE,
    };
    expect(actions.clearMessage()).to.deep.equal(expectedAction)
  });

});

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('MESSAGE -> ASYNC ACTION TESTS', () => {

  it('Set a message then set to invisible after 3 sec.', () => {
    const message = "Test should complete successfully.";
    const type = "success";
    const payload = {
      message: message,
      messageType: type,
      icon: "ok",
    };

    const expectedActions = [
      {type: MESSAGE.SET_MESSAGE, payload: payload},
      {type: MESSAGE.SET_VISIBLE, payload: false}
    ];

    const store = mockStore({});

    return store.dispatch(actions.setMessageWithTimeout(message, type)).then(() => {
      expect(store.getActions()).to.deep.equal(expectedActions)
    });
  });

});
