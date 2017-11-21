import React from 'react';
import Table from '../../table/TableView';
import { tableConfigA, tableConfigB } from "./tableConfig";
import { shallow } from 'enzyme';


function setup() {
  const props = {
    config: tableConfigA,
  };
  const enzymeWrapper = shallow(<Table {...props} />);
  return {
    props,
    enzymeWrapper
  }
}

describe('Table ->', () => {

  it.only('Table should exist.', () => {
    const { enzymeWrapper, props} = setup();
    const table = enzymeWrapper.find('table');
    expect(table).to.have.length(1);
  });

  it.only('TableFooter should exist.', () => {
    const { enzymeWrapper, props } = setup();
    const table = enzymeWrapper.find('TableFooter');
    expect(table).to.have.length(1);
  });

  it.only('Table config change should return false on should component update', () => {
    const { enzymeWrapper, props} = setup();
    enzymeWrapper.instance()._reloadTableData = jest.fn();
    enzymeWrapper.update();
    const shouldUpdate = enzymeWrapper.instance().shouldComponentUpdate({config: tableConfigB});
    expect(shouldUpdate).to.be.false;
  });

});