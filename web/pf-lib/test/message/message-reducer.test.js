import React from 'react';
import reducer from '../../message/messageReducer';
import { MESSAGE } from '../../message/messageConstants'

import { expect } from 'chai';


let initialState = {};

describe('MESSAGE -> REDUCER TESTS', () => {
  beforeEach(() => {
    initialState = {
      message: null,
      visible: null,
      messageType: null,
      icon: null,
    }
  });

  it('Should return the initial state', () => {
    expect(reducer(undefined, {})).to.deep.equal(
      {
        message: null,
        visible: null,
        messageType: null,
        icon: null
      })
  });

  it('should handle SET_VISIBLE', () => {
    const action = {type: MESSAGE.SET_VISIBLE, payload: true};
    const actualState = reducer(initialState, action);
    expect(actualState.visible).to.be.equal(true);
  });

  it('should handle SET_MESSAGE', () => {
    const message = "Test should complete successfully.";
    const type = "success";
    const icon = "ok";
    const payload = {
      message: message,
      messageType: type,
      icon: icon,
    };
    const action = {type: MESSAGE.SET_MESSAGE, payload};
    const expectedState = {
      message: message,
      messageType: type,
      icon: icon,
      visible: true
    };
    const actualState = reducer(initialState, action);

    expect(actualState).to.deep.equal(expectedState);
  });

  it('should handle CLEAR_MESSAGE', () => {
    const action = {type: MESSAGE.CLEAR_MESSAGE};
    const actualState = reducer(initialState, action);
    expect(actualState.visible).to.be.equal(null);
    expect(actualState.message).to.be.equal(null);
  });
});
