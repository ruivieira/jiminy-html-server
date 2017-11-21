import React, { Component } from "react";
import { expect } from 'chai';
import { App } from '../../appContainer/App';
import { shallow } from 'enzyme';

class testComponent extends Component{
  static render(){
    return <p>Test Render</p>
  }
}

let viewsConfig = [
  {component: testComponent, path: '/'},
];

let navbarConfig = {
  categories: [{title: 'Dashboard', link: '/'},],
  titleSrc: {path: '../static/build/img/brand.svg', alt: 'Patternfly Demo App'}
};

function setup() {
  const props = {
    viewsConfig,
    navbarConfig,
  };
  const enzymeWrapper = shallow(
      <App {...props} />
  );
  return {
    props,
    enzymeWrapper
  }
}

describe('APPCONTAINER -> CONTAINER TEST', () => {
  describe('Header', () => {
    it('Should render without issues.', () => {
      const { enzymeWrapper } = setup();
      expect(enzymeWrapper).to.have.length(1);
    });
  })
});


