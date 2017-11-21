import React from 'react';
import { Message } from '../../message/container/Message';
import { mount } from 'enzyme';

function setup() {
  const props = {
    message: "Test Message.",
    messageType: "Success",
    icon: "ok",
    visible: true,
    clearMessage: jest.fn(),
  };
  const enzymeWrapper = mount(<Message {...props} />);
  return {
    props,
    enzymeWrapper
  }
}

describe('MESSAGE -> CONTAINER TEST', () => {
  describe('Button', () => {
    it('Should invoke clearmessage on click.', () => {
      const { enzymeWrapper, props } = setup();
      const button = enzymeWrapper.find('button');
      expect(button.hasClass('button'));
      expect(props.clearMessage.mock.calls.length).to.equal(0);
      button.simulate('click');
      expect(props.clearMessage.mock.calls.length).to.equal(1);
    });
  })
});