import React from 'react';
import TableFooter from '../../table/TableFooter';
import { shallow } from 'enzyme';


function setup() {
  return shallow(<TableFooter/>);
}

describe('Table ->', () => {

  it.only('TableFooter should exist.', () => {
    const enzymeWrapper= setup();
    const form = enzymeWrapper.find('form');
    expect(form).to.have.length(1);
  });

});