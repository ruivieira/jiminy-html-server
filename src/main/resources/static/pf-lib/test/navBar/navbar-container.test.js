import React from "react";
import { expect } from 'chai';
import { NavBar } from '../../navBar/components/NavBar';
import { shallow } from 'enzyme';

function setup() {
  let navbarConfig = {
    // Create 2 entries to ensure non-active navbar link is set without issues.
    categories: [
      {title: 'Dashboard', link: '/'},
      {title: 'ListView', link: '/listView',}
    ],
    titleSrc: {path: '../static/build/img/brand.svg', alt: 'Patternfly Demo App'}
  };

  let props = {config: navbarConfig};
  const enzymeWrapper = shallow(
      <NavBar {...props} />
  );
  return {
    props,
    enzymeWrapper
  }
}

describe('NAVBAR -> CONTAINER TEST', () => {
    it('Should render without issues.', () => {
      const { enzymeWrapper } = setup();
      expect(enzymeWrapper).to.have.length(1);
    });
});
