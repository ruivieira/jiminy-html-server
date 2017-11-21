import React from 'react';
import { getIcon } from '../../message/utils';
import { expect } from 'chai';
describe('MESSAGE -> CONTAINER TEST', () => {
    it('Should return appropriate icons given message type.', () => {
      let icon = 'danger';
      expect(getIcon(icon)).to.be.equal("error-circle-o");
      icon = 'success';
      expect(getIcon(icon)).to.be.equal("ok");
      icon = 'warning';
      expect(getIcon(icon)).to.be.equal("warning-triangle-o");
      icon = 'info';
      expect(getIcon(icon)).to.be.equal("info");
    });
});